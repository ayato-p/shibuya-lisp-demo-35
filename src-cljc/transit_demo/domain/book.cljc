(ns transit-demo.domain.book
  (:require [transit-demo.proto :as p]))

(defrecord Book [title author publisher price])

(defn new-book [title author price publisher]
  (map->Book {:title title
              :author author
              :price price
              :publisher publisher}))
