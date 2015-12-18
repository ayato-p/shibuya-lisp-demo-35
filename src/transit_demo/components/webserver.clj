(ns transit-demo.components.webserver
  (:require [com.stuartsierra.component :as component]
            [immutant.web :as web]))

(defn default-handler [req]
  {:status 200
   :body "<h1>Server running!!</h1>"
   :headers {"content-type" "text/html; charset=utf-8"}})

(defrecord WebServer [handler host port]
  component/Lifecycle
  (start [self]
    (if-not (:server self)
      (do
        (println (str "Start server: " host ":" port))
        (assoc self :server (web/run (:handler handler) {:port port :host host})))
      self))
  (stop [self]
    (if-let [server (:server self)]
      (web/stop server)
      self)))

(defn new-webserver [{:as conf :keys [host port] :or {host "localhost" port 3000}}]
  (map->WebServer {:host host :port port}))
