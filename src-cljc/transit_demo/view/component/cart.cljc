(ns transit-demo.view.component.cart
  (:require [transit-demo.impl :as impl]
            #?@(:clj [[transit-demo.db :as db]]
                :cljs [[reagent.core :as reagent :refer [atom]]
                       [re-frame.core :refer [subscribe dispatch]]])))

#?(:clj
   (def fn-table
     {:books db/find-book
      :cart (fn [& args])}))

#?(:clj
   (defn subscribe [[kw & args]]
     (let [f (get fn-table (keyword (name kw)))]
       (apply f args))))

(defn book-list-component [books]
  [:table
   [:thead
    [:tr
     [:th "タイトル"] [:th "著者"] [:th "出版社"] [:th "価格"] [:th "税込み"] [:th]]]
   [:tbody
    (for [{:as b :keys [id title author publisher price]} books]
      ^{:key id}
      [:tr
       [:td title]
       [:td author]
       [:td publisher]
       [:td price]
       [:td (impl/tax-include-price b)]
       [:td [:input {:type "button"
                     :value "カートに入れる"
                     :on-click #?(:clj ""
                                  :cljs #(dispatch [:transit-demo.handler.cart/add-to-cart b]))}]]])]])

(defn book-search-component []
  (let [books (subscribe [:transit-demo.sub.cart/books])
        search-word (atom "")]
    (fn []
      [:div
       [:h2 "本の検索"]
       [:input {:type :text
                :placeholder "ここにタイトルを入力"
                :on-change #?(:clj ""
                              :cljs #(reset! search-word (.-value (.-target %))))}]
       [book-list-component #?(:clj books
                               :cljs (doall (filter #(re-find (re-pattern (.toLowerCase (str ".*" @search-word ".*")))
                                                              (.toLowerCase (:title %)))
                                                    @books)))]])))

(defn item-list-component []
  (let [cart (subscribe [:transit-demo.sub.cart/cart])]
    (when (not-empty (:items #?(:clj cart :cljs @cart)))
      [:table
       [:thead
        [:tr [:th "商品"] [:th "価格"] [:th "数量"]]]
       [:tbody
        (for [[k v] (group-by :title (:items #?(:clj cart :cljs @cart)))
              :let [{:as i :keys [title price]} (first v)]]
          ^{:key k}
          [:tr
           [:td title]
           [:td (impl/tax-include-price i)]
           [:td (count v)]])]])))

(defn cart-result-coomponent []
  (let [cart (subscribe [:transit-demo.sub.cart/cart])]
    [:span "合計: " (impl/tax-include-price #?(:clj cart :cljs @cart))]))

(defn cart-component []
  [:div
   [:h2 "カートの中身"]
   [item-list-component]
   [cart-result-coomponent]])

(defn app-component []
  [:div
   [book-search-component]
   [cart-component]])
