(ns transit-demo.sub.cart
  (:require-macros [reagent.ratom :refer [reaction]])
  (:require [re-frame.core :refer [register-sub]]))

(register-sub
 ::books
 (fn [db _]
   (reaction (:books @db))))

(register-sub
 ::cart
 (fn [db _]
   (reaction (:cart @db))))
