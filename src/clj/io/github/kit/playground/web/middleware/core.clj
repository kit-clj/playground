(ns io.github.kit.playground.web.middleware.core
  (:require
    [io.github.kit.playground.env :as env]
    [ring.middleware.defaults :as defaults]
    [ring.middleware.session.cookie :as cookie]))

(defn wrap-base
  [{:keys [metrics site-defaults-config cookie-secret] :as opts}]
  (let [cookie-store (cookie/cookie-store {:key (.getBytes ^String cookie-secret)})]
    (fn [handler]
      (cond-> ((:middleware env/defaults) handler opts)
              true (defaults/wrap-defaults
                     (assoc-in site-defaults-config [:session :store] cookie-store))
              ))))
