import catalogueView from "../views/catalogueView.js";
import overlayView from "../views/overlayView.js";

const addExerciseButtonEl = document.querySelector(".training-creation-form__add-exercise-form-button");

addExerciseButtonEl.addEventListener("click", event => {
  event.preventDefault();
  const lastExerciseEl = addExerciseButtonEl.previousSibling();
  const lastOrdinal = Number(lastExerciseEl.querySelector(`input[name="ordinal"]`).getAttribute("value"))
  addExerciseButtonEl.insertAdjacentHTML("beforebegin", `
   <div class="training-creation-form__exercise">
              <div class="training-creation-form__exercise-name">
              <label>Название упражнения</label>
              <input type="text" name="exercise-name" required/>
          </div>
              <div class="training-creation-form__approach-count">
                  <label>количество подходов</label>
                  <input type="number" name="approach-count" required/>
              </div>
              <div class="training-creation-form__count-of-approach">
                  <label>количество повторений</label>
                  <input type="number" name="count-of-approach" required/>
              </div>
              <input type="number" name="ordinal" hidden value="${lastOrdinal + 1}" required/>
          </div>`)

});