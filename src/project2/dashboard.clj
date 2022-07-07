(ns project2.dashboard
  (:require [hiccup.page :refer [html5 include-css]]))

(def dashboard 
 (html5
  [:head [:title "Quiz with Clojure"]
   (include-css "dashboard.css")]
  [:body 
   [:h1 "SIMPLE QUIZ"] 
   [:p "Yuk tes kemampuanmu dengan Simple Quiz!"]
   [:p "Jawab dengan cepat dan tepat ya..."]
   [:div.card1 
    [:h2 "MATEMATIKA"]
    [:p
     "Pelajaran matematika di kelas sering nggak masuk ke otak? Tes seberapa cepat dan akurat kamu dalam mengerjakan persoalan numerik disini!"]
    [:a.button {:href "/Matematika"} "MULAI"]]
   [:div.card2 
    [:h2 "VERBAL LOGIC"]
    [:p
     "Ukur sejauh mana pemahamanmu dalam cara berpikir verbal dan logika. Jangan sampai dibilang lemot karena gagal paham waktu diajak bicara yaa!!"]
    [:a.button {:href "/Verbal"} "MULAI"]]]
   [:div.card3 
    [:h2 "BAHASA INGGRIS"]
    [:p
     "Zaman sekarang masih nggak bisa Bahasa Inggris? Sekarang Bahasa Inggris seperti penghubung, maka dari itu yuk tingkatin skillmu berbahasa Inggris! "] 
    [:a.button {:href "/English"} "MULAI"]]))
  
