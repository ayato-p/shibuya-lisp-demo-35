(ns transit-demo.system
  (:require [com.stuartsierra.component :as c]
            [transit-demo.components.endpoint :as ep]
            [transit-demo.components.pre-loader :as pl]
            [transit-demo.components.webserver :as server]))

(defonce system nil)

(defn new-system [conf]
  (c/map->SystemMap
   {:pre-loader (pl/new-pre-loader conf)
    :handler (ep/new-endpoint conf)
    :server (c/using (server/new-webserver conf)
                     [:handler :pre-loader])}))

(defn shutdown []
  (alter-var-root #'system c/stop))

(defn boot [conf]
  (alter-var-root
   #'system
   (fn [old-system]
     (if old-system
       (do
         (println "System rebooting...")
         (c/stop old-system)
         (c/start (new-system conf)))
       (c/start (new-system conf))))))
