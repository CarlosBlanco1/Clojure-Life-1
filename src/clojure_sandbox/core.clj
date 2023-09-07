(ns clojure-sandbox.core)

;Carlos Blanco 09/06/2023
;Conway's game of life rules 
;-a dead cell with 3 live neighbors will live again
;-live cell with less than 2 or more than 3 neighbors dies
;-live cell with exactly 2 or 3 neighbors keeps living

; 1
(defn neighbors-of-cell [[x y]]
  (list [(inc x) (inc y)]
        [x (inc y)]
        [(dec x) (inc y)]
        [(dec x) y]
        [(inc x) y]
        [(dec x) (dec y)]
        [x (dec y)]
        [(inc x) (dec y)]))
;2
(defn living-neighbors-cell-living [[cell] living-cells]
  (count (filter living-cells (neighbors-of-cell cell))))

;3
(defn living-neighbors-living [set-of-cells]
  (fn [cell]
    (count (filter set-of-cells (neighbors-of-cell cell)))))
;4
(defn will-live-cell-living [[cell] set-of-living-cells]
  (let [living-neighbors-count (living-neighbors-living set-of-living-cells)]
    (if (or (= (living-neighbors-count cell) 3)
            (= (living-neighbors-count cell) 2))
      true
      false)))
;5
(defn next-generation-living [set-of-living-cells]
  (filter (fn [cell] (will-live-cell-living [cell] set-of-living-cells)) set-of-living-cells))

(defn -main []
  (let [xd #{[0 0] [0 1] [1 0] [1 1]}
        cell-to-check [0 1]]

    (println (will-live-cell-living [cell-to-check] xd))

    ;should have 3 living neighbors
    (println (living-neighbors-cell-living [cell-to-check] xd))

    ;all cells should survive in the next generation and they should all be printed out
    (doseq [cell (next-generation-living xd)]
      (println cell))))










