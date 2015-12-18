(ns transit-demo.handler.api
  (:require [ring.util.response :as res]
            [transit-demo.domain.book :as book]
            [transit-demo.util.handler :refer [defhandler]]))

(def ^:private books
  [(book/new-book "Clojure Programming" "Chas Emerick" 6648 "O'Reilly Media")
   (book/new-book "Clojure Cookbook" "Luke VanderHart" 4775 "O'Reilly Media")
   (book/new-book "Living Clojure" "Carin Meier" 2843 "O'Reilly Media")
   (book/new-book "Clojure Recipes" "Julian Gamble" 4243 "Addison-Wesley Professional")
   (book/new-book "Web Development With Clojure" "Dmitri Sotnikov" 4766 "Pragmatic Bookshelf")
   (book/new-book "Clojure Reactive Programming" "Leonardo Borges" 5957 "Packt Publishing")
   (book/new-book "Clojure Data Structures and Algorithms Cookbook" "Rafik Naccache" 6619 "Packt Publishing")
   (book/new-book "Clojure for the Brave and True" "Daniel Higginbotham" 4487 "No Starch Press")
   (book/new-book "Clojure Applied" "Alex Miller" 5031 "Pragmatic Bookshelf")
   (book/new-book "The Joy of Clojure" "Michael Fogus" 6092 "Manning Pubns Co")
   (book/new-book "Clojure Web Development Essentials" "Ryan Baldwin" 5985 "Packt Publishing")
   (book/new-book "Mastering Clojure" "Akhil Wali" 5286 "Packt Publishing")
   (book/new-book "Mastering Clojure Macros" "Colin Jones" 1989 "Pragmatic Bookshelf")
   (book/new-book "Clojure Data Analysis Cookbook" "Eric Rochester" 5815 "Packt Publishing")
   (book/new-book "Clojure High Performance Programming" "Shantanu Kumar" 4632 "Packt Publishing")
   (book/new-book "Clojure for Data Science" "Henry Garner" 5964 "Packt Publishing")
   (book/new-book "Clojure for Machine Learning" "Akhil Wali" 6630 "Packt Publishing")])

(defhandler find-book :api/find-book [req]
  (res/response {:books books}))
