(ns project2.questionverb
  (:require [hiccup.page :refer [html5 include-css]]
            [hiccup.form :as form]
            [ring.util.anti-forgery :refer (anti-forgery-field)]))

(defn soalv [soal]
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
    (form/label (str "no" i) (str "   " (get-in soal [i :soal :options 1 1])))]))

(defn soalverb [soal]
  (html5
   [:head [:title "QuestionVerbal"]
    (include-css "questionverb.css")]
   [:body [:h1 "Verbal & Logic"]
    (form/form-to
     [:post "/quizverb"]
    (soalv soal)
     [:br]
     (anti-forgery-field)
     [:h1 (form/submit-button "SUBMIT")])]))

