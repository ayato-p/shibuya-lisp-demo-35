(ns transit-demo.components.endpoint
  (:require [bidi.bidi :as bidi]
            [bidi.ring :as bidi-ring]
            [com.stuartsierra.component :as component]
            [transit-demo.middleware-set :as middleware-set]
            [transit-demo.util.namespace :as un]))

(extend-protocol bidi-ring/Ring
  clojure.lang.Keyword
  (request [k req _]
    (let [f (un/find-ring-handler k)]
      (f req))))

(defn- maybe-deref [var]
  (if (var? var)
    (deref var)
    var))

(defrecord Endpoint [routes handler]
  component/Lifecycle
  (start [self]
    (if-not (:handler self)
      (let [explicit-routes-map (maybe-deref routes)
            handler' (middleware-set/wrap-middleware-suite (bidi-ring/make-handler explicit-routes-map))]
        (assoc self :handler handler'))
      self))
  (stop [self]
    (dissoc self :handler)))

(defn new-endpoint [{:as conf :keys [routes]}]
  (map->Endpoint {:routes routes}))
