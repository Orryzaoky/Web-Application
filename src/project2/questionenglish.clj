(ns project2.questionenglish
  (:require [hiccup.page :refer [html5 include-css]]
            [hiccup.form :as form]
            [ring.util.anti-forgery :refer (anti-forgery-field)]))

(defn soaleng [soal] 
  (for [i (range 8)]
   [:div
    [:h2 (str (inc i) "/8")]
    [:br]
    [:p (get-in soal [i :soal :soal-text])]
    (form/hidden-field (str "no" i "-id") (get-in soal [i :problem-id]))
    (form/radio-button (str "no" i) false "A")
    (form/label (str "no" i) (str "   " (get-in soal [i :soal :options 0 1])))
    [:br]
    (form/radio-button (str "no" i) false "B")
    (form/label (str "no" i) (str "   " (get-in soal [i :soal :options 1 1])))
    [:br]
    (form/radio-button (str "no" i) false "C")
    (form/label (str "no" i) (str "   " (get-in soal [i :soal :options 2 1])))
    [:br]
    (form/radio-button (str "no" i) false "D")
    (form/label (str "no" i) (str "   " (get-in soal [i :soal :options 3 1])))]
    ))

(defn soalinggris [soal]
  (html5
   [:head [:title "QuestionEnglish"]
    (include-css "questionenglish.css")]
   [:body [:h1 "English"]
    (form/form-to
     [:post "/quizinggris"]
     (form/hidden-field "materi" (get-in soal [0 :topic]))
     (form/hidden-field "problems" soal)
     (soaleng soal)
     [:br]
     (anti-forgery-field)
     [:h1 (form/submit-button "SUBMIT")])]))

