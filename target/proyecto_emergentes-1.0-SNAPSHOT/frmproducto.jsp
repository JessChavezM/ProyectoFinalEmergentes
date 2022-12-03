<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
       <style>
            body {
                background-image: url(https://img.freepik.com/vector-gratis/fondo-juguetes-navidad-dibujados-mano_23-2148758008.jpg?w=2000);
                background-position: center;
                background-size: cover;
                height:100vh ;
                 font-style: italic;
            }
                 *{
            margin:0;
            padding:0;
        }
    
        #content{
            background-color:#fff;
            width:750px;
            padding:40px;
            margin:0 auto;
            border-left:30px solid #1D81B6;
            border-right:1px solid #ddd;
            -moz-box-shadow:0px 0px 16px #aaa;
        }
        .head{
            font-family:Helvetica,Arial,Verdana;
            text-transform:uppercase;
            font-weight:bold;
            font-size:12px;
            font-style:normal;
            letter-spacing:3px;
            color:#888;
            border-bottom:3px solid #f0f0f0;
            padding-bottom:10px;
            margin-bottom:10px;
        }
        .head a{
            color:#1D81B6;
            text-decoration:none;
            float:right;
            text-shadow:1px 1px 1px #888;
        }
        .head a:hover{
            color:#f0f0f0;
        }
        #content h1{
            font-family:"Trebuchet MS",sans-serif;
            color:#1D81B6;
            font-weight:normal;
            font-style:normal;
            font-size:56px;
            text-shadow:1px 1px 1px #aaa;
        }
        #content h2{
            font-family:"Trebuchet MS",sans-serif;
            font-size:34px;
            font-style:normal;
            background-color:#f0f0f0;
            margin:40px 0px 30px -40px;
            padding:0px 40px;
            clear:both;
            float:left;
            width:100%;
            color:#aaa;
            text-shadow:1px 1px 1px #fff;
        }


        </style>
        <title>Punto de venta</title>
    </head>
    <body>
        <div class="container">
            <h1>Formulario de productos</h1>   
            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="productos"/> 
            </jsp:include>
            <br>
            <form action="ProductoControlador" method="post">
                <input type="hidden" name="id" value="${producto.id}">
                <div class="form-group">
                    <label for="" class="form-label">Nombre</label>
                    <input type="text" class="form-control" name="nombre" value="${producto.nombre}" placeholder="Escriba su nombre">
                </div>

                <div class="form-group">
                    <label for="" class="form-label">Codigo</label>
                    <input type="text" class="form-control" name="codigo" value="${producto.codigo}" placeholder="Escriba su celular">
                </div>
                <div class="form-group">
                    <label for="" class="form-label">Clasificacion</label>
                    <input type="text" class="form-control" name="descripcion" value="${producto.descripcion}"  placeholder="Escriba su correo electronico">                       
                    </select>
                </div>
          
                <div class="form-group">
                  
                    <label for="" class="form-label">Imagen</label>
                    <input type="file" class="form-control" name="img" width="160" height="160" value="./img/${producto.img} "  placeholder="Escriba su celular">
                    <td><img width="160" height="160" src="./img/${producto.img} "/></td>
                </div>
              


                <script type="text/javascript">

             

                </script>


                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>





