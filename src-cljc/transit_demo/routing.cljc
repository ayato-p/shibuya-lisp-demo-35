(ns transit-demo.routing
  (:require [bidi.bidi :as bidi]
            [transit-demo.routes :as routes]))

(defn href
  ([route-id]
   (href route-id {}))
  ([route-id params-map]
   (apply bidi/path-for routes/main route-id
          (into [] (apply concat params-map)))))
