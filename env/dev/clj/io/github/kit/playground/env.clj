(ns io.github.kit.playground.env
  (:require
    [clojure.tools.logging :as log]
    [io.github.kit.playground.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init       (fn []
                 (log/info "\n-=[playground starting using the development or test profile]=-"))
   :start      (fn []
                 (log/info "\n-=[playground started successfully using the development or test profile]=-"))
   :stop       (fn []
                 (log/info "\n-=[playground has shut down successfully]=-"))
   :middleware wrap-dev
   :opts       {:profile       :dev
                :persist-data? true}})
