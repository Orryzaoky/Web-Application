(ns project2.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [project2.dashboard :as dashboard]
            [project2.questionmath :as math] 
            [project2.result :as result]
            [project2.problems :as prob] 
            [project2.questionverb :as verb] 
            [ring.util.response :as resp]
            [project2.questionenglish :as eng]))

(defroutes app-routes
  (GET "/" [] dashboard/dashboard)
  (GET "/Matematika" [] (math/soalmath (prob/take-soal (shuffle prob/soalmath))))
  (POST "/quiz" [no0 no0-id no1 no1-id no2 no2-id no3 no3-id no4 no4-id no5 no5-id no6 no6-id no7 no7-id]
    (do (prob/reset-score)
        (prob/check no0 no0-id)
        (prob/check no1 no1-id)
        (prob/check no2 no2-id)
        (prob/check no3 no3-id)
        (prob/check no4 no4-id)
        (prob/check no5 no5-id)
        (prob/check no6 no6-id)
        (prob/check no7 no7-id)
        (resp/redirect "/resultmath")))
  (GET "/resultmath" [] (result/resultmath prob/score prob/soalmath))
  (GET "/Pembahasan" [] result/bahasmath)
  
  (GET "/Verbal" [] (verb/soalverb (prob/take-soal (shuffle prob/soalverb))))
  (POST "/quizverb" [no0 no0-id no1 no1-id no2 no2-id no3 no3-id no4 no4-id no5 no5-id no6 no6-id no7 no7-id]
    (do (prob/reset-score)
        (prob/check no0 no0-id)
        (prob/check no1 no1-id)
        (prob/check no2 no2-id)
        (prob/check no3 no3-id)
        (prob/check no4 no4-id)
        (prob/check no5 no5-id)
        (prob/check no6 no6-id)
        (prob/check no7 no7-id)
        (resp/redirect "/resultverb")))
  (GET "/resultverb" [] (result/resultverb prob/score prob/soalverb))
  (GET "/PembahasanVerb" [] result/bahasverb)
  
  (GET "/English" [] (eng/soalinggris (prob/take-soal (shuffle prob/soalinggris))))
  (POST "/quizinggris" [no0 no0-id no1 no1-id no2 no2-id no3 no3-id no4 no4-id no5 no5-id no6 no6-id no7 no7-id]
    (do (prob/reset-score)
        (prob/check no0 no0-id)
        (prob/check no1 no1-id)
        (prob/check no2 no2-id)
        (prob/check no3 no3-id)
        (prob/check no4 no4-id)
        (prob/check no5 no5-id)
        (prob/check no6 no6-id)
        (prob/check no7 no7-id)
        (resp/redirect "/resultinggris")))
  (GET "/resultinggris" [] (result/resultinggris prob/score prob/soalinggris))
  (GET "/PembahasanEng" [] result/bahasinggris)

  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
