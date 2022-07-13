(ns project2.result
  (:require [hiccup.page :refer [html5 include-css]]
            [hiccup.form :as form]))

(defn resultmath [score wrong-question pass]
  (html5
   [:head [:title "Result"]
    (include-css "result.css")]
   [:h1 "SCORE"] 
   [:h4 @score]
   [:h3 "Jawaban benar"]
   [:h2 @score] 
   [:h3 "Jawaban salah"]
   [:h2 @wrong-question]
   [:h3 "Soal terlewat"]
   [:h2 @pass]
   [:br]
   [:a.button {:href "/Pembahasan"} [:h1 "Pembahasan >>"]]
   [:br]
   [:a.button {:href "/"} [:h1 "<< Kembali"]]))

(defn answer [soal index opsi pilihan]
 (if (get-in @soal [index :soal :options pilihan 0])
  [:p [:b (str opsi (get-in @soal [index :soal :options pilihan 1]))]]
  [:p (str opsi (get-in @soal [index :soal :options pilihan 1]))])) 

 (defn bahasmath [soalm]
  (html5
   [:head
    (include-css "result.css")]
   [:body
    [:h5 "Pembahasan Matematika"]
      (for [i (range 8)]
        [:div 
         [:h1 (str (inc i) "/8")]
         [:br]
         [:p (get-in @soalm [i :soal :soal-text])]
         (answer soalm i "A. " 0)
         (answer soalm i "B. " 1)
         (answer soalm i "C. " 2)
         (answer soalm i "D. " 3)
         (answer soalm i "E. " 4)
         [:br]
         [:p (get-in @soalm [i :bahas])]])
    [:a.button {:href "/"} [:h1 "Kembali"]]])) 
 
 
 (defn resultverb [score wrong-question pass]
  (html5
   [:head [:title "Result"]
    (include-css "result.css")]
   [:h1 "SCORE"] 
   [:h4 @score]
   [:h3 "Jawaban benar"]
   [:h2 @score] 
   [:h3 "Jawaban salah"]
   [:h2 @wrong-question]
   [:h3 "Soal terlewat"]
   [:h2 @pass]
   [:br]
   [:a.button {:href "/PembahasanVerb"} [:h1 "Pembahasan >>"]]
   [:br]
   [:a.button {:href "/"} [:h1 "<< Kembali"]]))

 (defn bahasverb [soalv]
  (html5
   [:head
    (include-css "result.css")]
   [:body
    [:h5 "Pembahasan Verbal & Logic"]
      (for [i (range 8)]
        [:div
         [:h1 (str (inc i) "/8")]
         [:br]
         [:p (get-in @soalv [i :soal :soal-text])]
         (answer soalv i "A. " 0)
         (answer soalv i "B. " 1)
         (answer soalv i "C. " 2)
         (answer soalv i "D. " 3)
         [:br]
         [:p (get-in @soalv [i :bahas])]])
    [:a.button {:href "/"} [:h1 "Kembali"]]]))
 
 
 (defn resultinggris [score wrong-question pass]
  (html5
   [:head [:title "Result"]
    (include-css "result.css")]
   [:h1 "SCORE"] 
   [:h4 @score]
   [:h3 "Correct Answer"]
   [:h2 @score] 
   [:h3 "Wrong Answer"]
   [:h2 @wrong-question]
   [:h3 "Unanswer Question"]
   [:h2 @pass]
   [:br]
   [:a.button {:href "/PembahasanEng"} [:h1 "Pembahasan >>"]]
   [:br]
   [:a.button {:href "/"} [:h1 "<< Kembali"]]))

 (defn bahasinggris [soaleng]
  (html5
   [:head
    (include-css "result.css")]
   [:body
    [:h5 "English Review"]
      (for [i (range 8)]
        [:div
         [:h1 (str (inc i) "/8")]
         [:br]
         [:p (get-in @soaleng [i :soal :soal-text])]
         (answer soaleng i "A. " 0)
         (answer soaleng i "B. " 1)
         (answer soaleng i "C. " 2)
         (answer soaleng i "D. " 3)
         [:br]
         [:p (get-in @soaleng [i :bahas])]])
    [:a.button {:href "/"} [:h1 "Kembali"]]]))
