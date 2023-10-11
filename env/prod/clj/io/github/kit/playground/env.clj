(ns io.github.kit.playground.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init       (fn []
                 (log/info "\n-=[playground starting]=-"))
   :start      (fn []
                 (log/info "\n-=[playground started successfully]=-"))
   :stop       (fn []
                 (log/info "\n-=[playground has shut down successfully]=-"))
   :middleware (fn [handler _] handler)
   :opts       {:profile :prod}})
