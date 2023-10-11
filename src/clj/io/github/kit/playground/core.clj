(ns io.github.kit.playground.core
  (:require
    [clojure.tools.logging :as log]
    [integrant.core :as ig]
    [io.github.kit.playground.config :as config]
    [io.github.kit.playground.env :refer [defaults]]

    ;; Edges       
    [kit.edge.server.undertow]
    [io.github.kit.playground.web.handler]

    ;; Routes
    [io.github.kit.playground.web.routes.api]
    )
  (:gen-class))

;; log uncaught exceptions in threads
(Thread/setDefaultUncaughtExceptionHandler
  (reify Thread$UncaughtExceptionHandler
    (uncaughtException [_ thread ex]
      (log/error {:what :uncaught-exception
                  :exception ex
                  :where (str "Uncaught exception on" (.getName thread))}))))

(defonce system (atom nil))

(defn stop-app []
  ((or (:stop defaults) (fn [])))
  (some-> (deref system) (ig/halt!))
  (shutdown-agents))

(defn start-app [& [params]]
  ((or (:start params) (:start defaults) (fn [])))
  (->> (config/system-config (or (:opts params) (:opts defaults) {}))
       (ig/prep)
       (ig/init)
       (reset! system))
  (.addShutdownHook (Runtime/getRuntime) (Thread. stop-app)))

(defn -main [& _]
  (start-app))
