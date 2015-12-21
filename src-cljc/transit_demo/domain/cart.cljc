(ns transit-demo.domain.cart)

(defrecord Cart [items])

(defn new-cart
  ([] (new-cart []))
  ([items] (map->Cart {:items items})))
