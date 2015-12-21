(ns transit-demo.util.reframe
  (:require [clojure.string :as str]))

(defn react-id-str [react-id]
  (assert (vector? react-id))
  (str "." (str/join "." react-id)))

(defn set-react-id [react-id element]
  (if-not (= (first element) :input)
    (update element 1 merge {:data-reactid (react-id-str react-id)})
    element))

(defn normalize [component]
  (if (map? (second component))
    component
    (into [(first component) {}] (rest component))))

(defn render
  ([component] (render [0] component))
  ([id component]
   (cond
     (fn? component) (render (component))

     (not (coll? component)) component

     (coll? (first component))
     (map-indexed #(render (conj id %1) %2) component)

     (keyword? (first component))
     (let [[tag opts & body] (normalize component)]
       (->> body
            (map-indexed #(render (conj id %1) %2))
            (into [tag opts])
            (set-react-id id)))

     (fn? (first component))
     (render id (apply (first component) (rest component))))))
