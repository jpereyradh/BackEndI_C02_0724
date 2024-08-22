window.addEventListener('load', function () {


    //Buscamos y obtenemos el formulario donde estan
    //los datos que el usuario pudo haber modificado de la pelicula
    const formulario = document.querySelector('#update_pelicula_form');

    formulario.addEventListener('submit', function (event) {
        let peliculaId = document.querySelector('#pelicula_id').value;

        //creamos un JSON que tendrá los datos de la película
        //a diferencia de una pelicula nueva en este caso enviamos el id
        //para poder identificarla y modificarla para no cargarla como nueva
        const formData = {
            id: document.querySelector('#pelicula_id').value,
            titulo: document.querySelector('#titulo').value,
            categoria: document.querySelector('#categoria').value,
            premios: document.querySelector('#premios').value,

        };

        //invocamos utilizando la función fetch la API peliculas con el método PUT que modificará
        //la película que enviaremos en formato JSON
        const url = '/peliculas';
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }
          fetch(url,settings)
          .then(response => response.json())

    })
 })

    //Es la funcion que se invoca cuando se hace click sobre el id de una pelicula del listado
    //se encarga de llenar el formulario con los datos de la pelicula
    //que se desea modificar
    function findBy(id) {
          const url = '/peliculas'+"/"+id;
          const settings = {
              method: 'GET'
          }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
              let pelicula = data;
              document.querySelector('#pelicula_id').value = pelicula.id;
              document.querySelector('#titulo').value = pelicula.titulo;
              document.querySelector('#categoria').value = pelicula.categoria;
              document.querySelector('#premios').value = pelicula.premios;
              //el formulario por default esta oculto y al editar se habilita
              document.querySelector('#div_pelicula_updating').style.display = "block";
          }).catch(error => {
              alert("Error: " + error);
          })
      }