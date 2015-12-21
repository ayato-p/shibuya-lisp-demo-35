(ns transit-demo.domain.book)

(defrecord Book [id title author publisher price])

(defn new-book [id title author price publisher]
  (map->Book {:id id
              :title title
              :author author
              :price price
              :publisher publisher}))
