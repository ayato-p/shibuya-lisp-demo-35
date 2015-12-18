(ns transit-demo.components.pre-loader
  (:require [com.stuartsierra.component :as component]
            [transit-demo.util.namespace :as un]))

(defn- maybe-kw->str [kw]
  (if (keyword? kw)
    (name kw)
    kw))

(defrecord PreLoader [prefixes]
  component/Lifecycle
  (start [self]
    (apply un/pre-require (map maybe-kw->str prefixes))
    self)
  (stop [self]
    self))

(defn new-pre-loader [{:as conf :keys [pre-load]}]
  (map->PreLoader {:prefixes (:prefixes pre-load)}))
