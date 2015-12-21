(ns transit-demo.db
  (:require [transit-demo.domain.book :as book]))

(def database
  {:books [(book/new-book 1   "Clojure Programming" "Chas Emerick" 6648 "O'Reilly Media")
           (book/new-book 2   "Clojure Cookbook" "Luke VanderHart" 4775 "O'Reilly Media")
           (book/new-book 3   "Living Clojure" "Carin Meier" 2843 "O'Reilly Media")
           (book/new-book 4   "Clojure Recipes" "Julian Gamble" 4243 "Addison-Wesley Professional")
           (book/new-book 5   "Web Development With Clojure" "Dmitri Sotnikov" 4766 "Pragmatic Bookshelf")
           (book/new-book 6   "Clojure Reactive Programming" "Leonardo Borges" 5957 "Packt Publishing")
           (book/new-book 7   "Clojure Data Structures and Algorithms Cookbook" "Rafik Naccache" 6619 "Packt Publishing")
           (book/new-book 8   "Clojure for the Brave and True" "Daniel Higginbotham" 4487 "No Starch Press")
           (book/new-book 9   "Clojure Applied" "Alex Miller" 5031 "Pragmatic Bookshelf")
           (book/new-book 10  "The Joy of Clojure" "Michael Fogus" 6092 "Manning Pubns Co")
           (book/new-book 11  "Clojure Web Development Essentials" "Ryan Baldwin" 5985 "Packt Publishing")
           (book/new-book 12  "Mastering Clojure" "Akhil Wali" 5286 "Packt Publishing")
           (book/new-book 13  "Mastering Clojure Macros" "Colin Jones" 1989 "Pragmatic Bookshelf")
           (book/new-book 14  "Clojure Data Analysis Cookbook" "Eric Rochester" 5815 "Packt Publishing")
           (book/new-book 15  "Clojure High Performance Programming" "Shantanu Kumar" 4632 "Packt Publishing")
           (book/new-book 16  "Clojure for Data Science" "Henry Garner" 5964 "Packt Publishing")
           (book/new-book 17  "Clojure for Machine Learning" "Akhil Wali" 6630 "Packt Publishing")]})

(defn find-book []
  (:books database))
