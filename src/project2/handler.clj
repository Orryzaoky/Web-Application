(ns project2.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [project2.dashboard :as dashboard]
            [project2.questionmath :as math]
            [project2.questionverb :as verb]
            [project2.questionenglish :as eng]
            [project2.result :as result]
            [project2.problems :as prob] 
            [ring.util.response :as resp]))

(defroutes app-routes
  (GET "/" [] dashboard/dashboard)
  (GET "/Matematika" [] (math/soalmath (prob/take-soal (shuffle prob/soalmath))))
  (POST "/quiz" [materi problems no0 no0-id no1 no1-id no2 no2-id no3 no3-id no4 no4-id no5 no5-id no6 no6-id no7 no7-id]
    (do (prob/reset-score)
        (prob/reset-wrong-question)
        (prob/reset-pass)
        (prob/check materi no0-id no0)
        (prob/check materi no1-id no1)
        (prob/check materi no2-id no2)
        (prob/check materi no3-id no3)
        (prob/check materi no4-id no4)
        (prob/check materi no5-id no5)
        (prob/check materi no6-id no6)
        (prob/check materi no7-id no7)
        (prob/simpan-soal problems)
        (resp/redirect "/resultmath")))
  (GET "/resultmath" [] (result/resultmath prob/score prob/wrong-question prob/pass))
  (GET "/Pembahasan" [] (result/bahasmath prob/soal)) 
  
  (GET "/Verbal" [] (verb/soalverb (prob/take-soal (shuffle prob/soalverb))))
  (POST "/quizverb" [materi problems no0 no0-id no1 no1-id no2 no2-id no3 no3-id no4 no4-id no5 no5-id no6 no6-id no7 no7-id]
    (do (prob/reset-score)
        (prob/reset-wrong-question)
        (prob/reset-pass)
        (prob/check materi no0-id no0)
        (prob/check materi no1-id no1)
        (prob/check materi no2-id no2)
        (prob/check materi no3-id no3)
        (prob/check materi no4-id no4)
        (prob/check materi no5-id no5)
        (prob/check materi no6-id no6)
        (prob/check materi no7-id no7)
        (prob/simpan-soal problems)
        (resp/redirect "/resultverb")))
  (GET "/resultverb" [] (result/resultverb prob/score prob/wrong-question prob/pass))
  (GET "/PembahasanVerb" [] (result/bahasverb prob/soal))
  
  (GET "/English" [] (eng/soalinggris (prob/take-soal (shuffle prob/soalinggris))))
  (POST "/quizinggris" [materi problems no0 no0-id no1 no1-id no2 no2-id no3 no3-id no4 no4-id no5 no5-id no6 no6-id no7 no7-id]
    (do (prob/reset-score)
        (prob/reset-wrong-question)
        (prob/reset-pass)
        (prob/check materi no0-id no0)
        (prob/check materi no1-id no1)
        (prob/check materi no2-id no2)
        (prob/check materi no3-id no3)
        (prob/check materi no4-id no4)
        (prob/check materi no5-id no5)
        (prob/check materi no6-id no6)
        (prob/check materi no7-id no7)
        (prob/simpan-soal problems)
        (resp/redirect "/resultinggris")))
  (GET "/resultinggris" [] (result/resultinggris prob/score prob/wrong-question prob/pass))
  (GET "/PembahasanEng" [] (result/bahasinggris prob/soal))

  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
