(ns project2.questionverb
  (:require [hiccup.page :refer [html5 include-css]]))

(def questionverb
  (html5
  [:head [:title "Question"]
   (include-css "questionverb.css")]
  [:body [:h1 "No. 1"] [:h2 "Verbal Logic"]]
    [:p "Manakah pilihan yang tepat untuk melengkapi kalimat berikut?"]
    [:p "Aku merasa lapar. ... aku segera mengambil makan."]
   [:table
    {:style "width:100%"} 
    [:tr
     [:td [:button [:b "A. "] "Sehingga"]]
     [:td [:button [:b "B. "] "Oleh karena itu"]]]
    [:tr
     [:td [:button [:b "C. "] "Karena"]]
     [:td [:button [:b "D. "] "Dengan demikian"]]]
    [:tr
     [:td [:button [:b "E. "] "Dan"]]]]
    
    [:a.button {:href "/Result"} [:b "NEXT >>"]]))

