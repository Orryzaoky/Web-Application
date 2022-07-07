(ns project2.result
  (:require [hiccup.page :refer [html5 include-css]]
            [hiccup.form :as form]))

(defn result [score soal]
  (html5
   [:head [:title "Result"]
    (include-css "result.css")]
   [:h2 "Score"]
   [:h1 @score]
   [:br]
   [:a.button {:href "/Pembahasan"} [:b "Pembahasan"]]
   [:br]
   [:a.button {:href "/"} [:b "Kembali"]]))

(defn bahas [soal]
  (html5
   [:head
    (include-css "result.css")]
   [:body
    (form/form-to
     [:post "/quiz"]
     [:h2 "Pembahasan"]
     [:h2 "MATEMATIKA"]
     [:div.cardpoin
      [:button [:a.button {:href "/bahasmath1"} "1"]]] 
     [:div.cardpoin
      [:button [:a.button {:href "/bahasmath2"} "2"]]])]))

 (defn bahasmath1 [soal]
   (html5
    [:head
     (include-css "result.css")]
    [:body
     (form/form-to
      [:post "/quiz"]
      [:p1 "Pembahasan soal matematika nomor 1"]
      [:p (get-in soal [0 :soal :option :bahas :problem-id])])]))

(defn bahasmath2 [soal]
   (html5
    [:head
     (include-css "result.css")]
    [:body
     (form/form-to
      [:post "/quiz"]
      [:p1 "Pembahasan soal matematika nomor 2"]
      [:p (get-in soal [1 :soal :option :bahas :problem-id])])]))
 
 (defn resultinggris [score1 soalinggris]
  (html5
   [:head [:title "Result"]
    (include-css "result.css")]
   [:h2 "Score"]
   [:h1 @score1]
   [:br]
   [:a.button {:href "/PembahasanEng"} [:b "Pembahasan"]]
   [:br]
   [:a.button {:href "/"} [:b "Kembali"]]))

(defn bahaseng [soalinggris]
  (html5
   [:head
    (include-css "result.css")]
   [:body
    (form/form-to
     [:post "/quizinggris"]
     [:h2 "Pembahasan"]
     [:h2 "BAHASA INGGRIS"]
     [:div.cardpoin
      [:button [:a.button {:href "/bahaseng1"} "1"]]]
     [:div.cardpoin
      [:button [:a.button {:href "/bahaseng2"} "2"]]])]))

 (defn bahaseng1 [soalinggris]
   (html5
    [:head
     (include-css "result.css")]
    [:body
     [:p1 "Pembahasan soal bahasa inggris nomor 1"]
     [:p (get-in soalinggris [0 :soal :option :bahas :problem-id])]]))

(defn bahaseng2 [soalinggris]
   (html5
    [:head
     (include-css "result.css")]
    [:body
     [:p1 "Pembahasan soal bahasa inggris nomor 2"]
     [:p (get-in soalinggris [1 :soal :option :bahas :problem-id])]]))