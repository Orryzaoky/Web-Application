(ns project2.result
  (:require [hiccup.page :refer [html5 include-css]]
            [hiccup.form :as form]))

(defn resultmath [score soal]
  (html5
   [:head [:title "Result"]
    (include-css "result.css")]
   [:h2 "Score"]
   [:h1 @score]
   [:br]
   [:a.button {:href "/Pembahasan"} [:b "Pembahasan"]]
   [:br]
   [:a.button {:href "/"} [:b "Kembali"]]))

 (defn bahasmath [soal]
  (html5
   [:head
    (include-css "result.css")]
   [:body
    (form/form-to
     [:post "/quiz"]
     [:h2 "Pembahasan"]
     [:h2 "MATEMATIKA"]
     [:div.cardpoin
      [:button [:a.button {:href "/bahasverb1"} "1"]]]
     [:div.cardpoin
      [:button [:a.button {:href "/bahasverb2"} "2"]]])]))
 
 (defn bahasverb [soal]
  (html5
   [:head
    (include-css "result.css")]
   [:body
    (form/form-to
     [:post "/quizverb"]
     [:h2 "Pembahasan"]
     [:h2 "Verbal & Logic"]
     [:div.cardpoin
      [:button [:a.button {:href "/bahasverb1"} "1"]]]
     [:div.cardpoin
      [:button [:a.button {:href "/bahasverb2"} "2"]]])]))

 (defn bahasverb [soal]
  (html5
   [:head
    (include-css "result.css")]
   [:body
    (form/form-to
     [:post "/quizverb"]
     [:h2 "Pembahasan"]
     [:h2 "VERBAL & LOGIC"]
     [:div.cardpoin
      [:button [:a.button {:href "/bahasverb1"} "1"]]]
     [:div.cardpoin
      [:button [:a.button {:href "/bahasverb2"} "2"]]])]))
 
 (defn resultinggris [score soal]
  (html5
   [:head [:title "Result"]
    (include-css "result.css")]
   [:h2 "Score"]
   [:h1 @score]
   [:br]
   [:a.button {:href "/PembahasanEng"} [:b "Pembahasan"]]
   [:br]
   [:a.button {:href "/"} [:b "Kembali"]]))

(defn bahasinggris [soal]
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