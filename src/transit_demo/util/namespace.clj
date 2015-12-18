(ns transit-demo.util.namespace
  (:require [bultitude.core :as b]))

(defn all-ns-interns []
  (->> (all-ns)
       (map ns-interns)
       (mapcat vals)))

(defn find-ring-handler
  "Just for development, because this finder will survey all namespaces everytime.
  Need consider using cache or something else."
  [kw]
  (->> (all-ns-interns)
       (filter #(= (:handler-tag (meta %)) kw))
       first))

(defn pre-require [& prefixes]
  (doseq [p prefixes]
    (doseq [ns-sym (b/namespaces-on-classpath :prefix p)]
      (require ns-sym))))
