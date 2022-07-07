(ns project2.questionenglish
  (:require [hiccup.page :refer [html5 include-css]]
            [hiccup.form :as form]
            [ring.util.anti-forgery :refer (anti-forgery-field)]))

(defn soalinggris1 [soalinggris]
  (html5
   [:head [:title "QuestionEnglish"]
    (include-css "questionenglish.css")]
   [:body [:h1 "1/8"] [:h2 "Bahasa Inggris"]
    (form/form-to
     [:post "/quizinggris"]
     [:p (get-in soalinggris [0 :soal :soal-text])]
     (form/radio-button (str "no" 0) false "A")
     (form/label (str "no" 0) (str "   " (get-in soalinggris [0 :soal :options 0 1])))
     [:br]
     (form/radio-button (str "no" 0) false "B")
     (form/label (str "no" 0) (str "   " (get-in soalinggris [0 :soal :options 1 1])))
     [:br]
     (form/radio-button (str "no" 0) false "C")
     (form/label (str "no" 0) (str "   " (get-in soalinggris [0 :soal :options 2 1])))
     [:br]
     (form/radio-button (str "no" 0) false "D")
     (form/label (str "no" 0) (str "   " (get-in soalinggris [0 :soal :options 3 1])))
     [:br] 
     [:a.button {:href "/soalinggris2"} "Next"])])) 

(defn soalinggris2 [soalinggris]
  (html5
   [:head [:title "QuestionEnglish"]
    (include-css "questionenglish.css")]
   [:body [:h1 "2/8"] [:h2 "Bahasa Inggris"]
    (form/form-to
        [:post "/quizinggris"]
        [:p (get-in soalinggris [1 :soal :soal-text])]
        (form/radio-button (str "no" 1) false "A")
        (form/label (str "no" 1) (str "   " (get-in soalinggris [1 :soal :options 0 1])))
        [:br]
        (form/radio-button (str "no" 1) false "B")
        (form/label (str "no" 1) (str "   " (get-in soalinggris [1 :soal :options 1 1])))
        [:br]
        (form/radio-button (str "no" 1) false "C")
        (form/label (str "no" 1) (str "   " (get-in soalinggris [1 :soal :options 2 1])))
        [:br]
        (form/radio-button (str "no" 1) false "D")
        (form/label (str "no" 1) (str "   " (get-in soalinggris [1 :soal :options 3 1])))
    [:br]
    (anti-forgery-field)
    (form/submit-button "Submit"))]))
