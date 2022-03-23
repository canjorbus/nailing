import React, { useState, useEffect } from "react";
import ReactDOM from 'react-dom'
import SlidingPane from "../../components/SlidingPane/index.tsx";
import PropertyPanel from "../../components/PropertyPanel/index.js";
import $ from 'jquery'; 


export function Cita() {
    const [state, setState] = useState({
        isPaneOpen: false,
        id: "",
        name: "",
        buttons: [],
    })

    useEffect(() => {
<<<<<<< HEAD
        if (state.id !== "" && state.buttons.length === 0) {
=======
        if(state.id !== "" && state.buttons.length == 0){
>>>>>>> parent of f5e69d1 (Merge branch 'release-v0' into Task-031-Personalización-de-uña-#31)
            $.ajax({
                method: "GET",
                headers: {
                    "Authorization": "Basic " + btoa(sessionStorage.getItem("userName") + ":" + sessionStorage.getItem("userPassword"))
                },
                url: "https://nailingtest.herokuapp.com/tipos/centro/" + state.id.toString(),
                success: function (data) {
                    console.log("Servicios recibidos");
                    console.log(data);
                    //El data que llegue debe tener 1 atributo, buttons: objeto boton con sus propiedades y carac siguiente
                    //FORMATO JSON: {"tipo": [{"id": 1, "nombre" : "Relleno", "coste": 1, "tiempo": 3, "siguienteFase": Material, "centro":...}, ...] }
                    setState({ id: state.id, name: state.name, isPaneOpen: false, buttons: data});
                }
            });
        }
    // eslint-disable-next-line react-hooks/exhaustive-deps
    }, [state.id]);

    useEffect(() => {
        if(state.buttons.length !== 0){
            sessionStorage.setItem("centreId", state.id);
            setState({ id: state.id, name: state.name, isPaneOpen: true, buttons: state.buttons});
        }
    // eslint-disable-next-line react-hooks/exhaustive-deps
    }, [state.buttons]);

    return (
        <>
<<<<<<< HEAD

            <button id="1" className="border-2 border-purple-600 text-black px-32 py-3 rounded-md text-1xl font-medium hover:bg-purple-600 transition duration-300"
                onClick={(event) => setState({ isPaneOpen: false, id: event.target.id, name: event.target.innerText, buttons: []})}>Centro1</button>
            <button id="2" className="border-2 border-purple-600 text-black px-32 py-3 rounded-md text-1xl font-medium hover:bg-purple-600 transition duration-300"
=======
            <button id="420" className="border-2 border-purple-600 text-black px-32 py-3 rounded-md text-1xl font-medium hover:bg-purple-600 transition duration-300"
                onClick={(event) => setState({ isPaneOpen: false, id: event.target.id, name: event.target.innerText, buttons: []})}>Centro1</button>
            <button id="421" className="border-2 border-purple-600 text-black px-32 py-3 rounded-md text-1xl font-medium hover:bg-purple-600 transition duration-300"
>>>>>>> parent of f5e69d1 (Merge branch 'release-v0' into Task-031-Personalización-de-uña-#31)
                onClick={(event) => setState({ isPaneOpen: false, id: event.target.id, name: event.target.innerText, buttons: []})}>Centro2</button>            
            <div class="centerIdDiv" id={state.id}>
                <SlidingPane children={<div id={"TipoContainer"} class="propertyContainer"><PropertyPanel name="Tipo" buttons={state.buttons} /></div> } title={state.name} isOpen={state.isPaneOpen} from="bottom" width="100%" onRequestClose={() => { setState({ isPaneOpen: false, id: "", name: "", buttons: [] });}}/>
            </div>
        </>
    )
}

