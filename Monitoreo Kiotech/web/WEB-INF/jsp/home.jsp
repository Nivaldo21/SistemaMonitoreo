<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//ES"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <spring:url value="/resources/js/jquery.js" var="jquery" />
        <spring:url value="/resources/js/home.js" var="homeJS" />
        <spring:url value="/resources/js/menu.js" var="menuJS" />
        <spring:url value="/resources/css/home.css" var="homeCSS" />
        <spring:url value="/resources/images/logo.png" var="logo" />
        <spring:url value="/resources/images/home.png" var="homeIMG" />
        <spring:url value="/resources/images/form1.png" var="userIMG" />
        <spring:url value="/resources/css/bootstrap/bootstrap.css" var="btCSS" />
        <spring:url value="/resources/css/menuKiosko.css" var="mainuCSS" />
        <spring:url value="/resources/js/menuKiosko.js" var="mainuJS" />
        <spring:url value="/resources/js/bootstrap/bootstrap.js" var="btJS" />
        <spring:url value="/resources/js/homeAJAX.js" var="AJAX" />
        <spring:url value="/resources/alertifyjs/css/alertify.css" var="alertifyCSS" />
        <spring:url value="/resources/css/spinner.css" var="spinnerCSS" />
        <spring:url value="/resources/css/animate.min.css" var="animeteCSS" />
        <spring:url value="/resources/css/menu.css" var="menuCSS" />
        <spring:url value="/resources/js/spinner.js" var="spinnerJS" />
        <spring:url value="/resources/alertifyjs/alertify.js" var="alertifyJS" />

        <link rel="stylesheet" href="${homeCSS}">
        <link rel="shortcut icon" href="${logo}">
        <link rel="shortcut icon" href="${homeIMG}">
        <link rel="stylesheet" href="${btCSS}">
        <link rel="stylesheet" href="${alertifyCSS}">
        <link rel="stylesheet" href="${spinnerJS}">
        <link rel="stylesheet" href="${animateCSS}">
        <link rel="stylesheet" href="${menuCSS}">
        <link rel="stylesheet" href="${mainuCSS}">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HOME</title>


    </head>

    <body>

      <!-- Menú lateral -->
      <div id="sidebar" class="sidebar collapse ">
        <h4>Menú <span id="cerrarMenu" class=""><i class="fas fa-chevron-left"></i></span></h4>
        <ul class="menu">
          <li><a id="menuMonitoreo" class="" href="<c:url value='home.htm' />"><i class="icono izquierda fas fa-desktop"></i> Monitoreo de Kioscos</a></li>
          <li><a id="menuAlertas" class="" href="#"><i class="icono izquierda fas fa-exclamation-circle"></i> Alertas <i class="icono derecha fas fa-chevron-down"></i></a>
            <ul>

                <li><a id="historial" class="" href="<c:url value='historial.htm' />"><i class="icono izquierda fa fa-history"></i> Historial de alertas</a></li>
                <li><a id="configEnvio" class="" href="<c:url value='medio_envio.htm' />"><i class="icono izquierda fas fa-truck"></i> Medio de envío</a></li>
                <li><a id="configEvento" class="" href="<c:url value='eventos.htm' />"><i class="icono izquierda fas fa-calendar-alt"></i> Config. de eventos</a></li>
                <li><a id="usuarios" class="" href="<c:url value='asignar_usuario.htm' />"><i class="icono izquierda fas fa-user-plus"></i> Asignación de usuarios</a></li>

            </ul>
          </li>
          <li><a id="menuPublicidad" class="" href="#"><i class="icono izquierda fas fa-play-circle"></i> Publicidad <i class="icono derecha fas fa-chevron-down"></i> </a>
            <ul>

                <li><a id="archivosMultimedia" class="" href="<c:url value='archivos.htm' />"><i class="icono izquierda fas fa-file-archive"></i> Archivos multimedia</a></li>
                <li><a id="listasReproduccion" class="" href="<c:url value='listas.htm' />"><i class="icono izquierda fas fa-list-ul"></i> Listas de reproduccion</a></li>
                <li><a id="programacionListas" class="" href="<c:url value='programacion.htm' />"><i class="icono izquierda fas fa-tasks"></i> Programación de listas</a></li>

            </ul>
          </li>
          <li><a id="salir" class="" href="<c:url value='cerrar_sesion.htm' />"><i class=" icono izquierda fas fa-sign-out-alt "></i> Cerrar Sesión</a></li>
        </ul>

        <div class="userCar text-center mt-5">
          <img  src="${userIMG}" height="50px" class="navb" alt="">
          <p class="mt-3">Bienvenido<br>${usuario}</p>
          <p>Agencia: ${agencia}</p>
        </div>


      </div>
      <div class="contenido">
        <span id="abrirMenu"><i class="fas fa-list-ul"></i></span>
      </div>
      <!-- Menú lateral -->

      <div class="container">
          <h2 class="text-center pt-5">Monitoreo de kioscos</h2>
      </div>

      <div class="container mt-4">
        <div class="row">
          <!--Inicia código de barra lateral de kioskos-->
          <div class="col-md-2">
            <h5 class="bg-dark text-center">Kioscos</h5>
            <hr>
              <div class="container text-left">

                <c:forEach items="${ag}" var="dato">
                  <button id="${dato.id_agencia}"type="button" class="btn btn-secondary divAgencia agencia">${dato.nombre}</button>
                  <div class="kioscosAG">
                    <c:forEach items="${kiosco}" var="dato2">
                      <c:if test="${dato.id_agencia == dato2.id_agencia}">
                        <c:if test="${dato2.id_status == 1}">
                          <button id="${dato2.id_kiosco}" name="${dato2.nombre}" value="${dato.nombre}" type="button" class="btn btn-secondary kiosko ml-2"><i class="fas fa-desktop mr-1"></i>${dato2.nombre}</button>
                        </c:if>
                        <c:if test="${dato2.id_status == 2}">
                          <button id="${dato2.id_kiosco}" name="${dato2.nombre}" value="${dato.nombre}" type="button" class="btn btn-secondary kiosko ml-2"><i class="fas fa-exclamation-triangle text-warning mr-1"></i>${dato2.nombre}</button>
                        </c:if>
                        <c:if test="${dato2.id_status == 3}">
                          <button id="${dato2.id_kiosco}" name="${dato2.nombre}" value="${dato.nombre}" type="button" class="btn btn-secondary kiosko ml-2"><i class="fas fa-plug text-danger mr-1"></i>${dato2.nombre}</button>
                        </c:if>
                        <c:if test="${dato2.id_status == 4}">
                          <button id="${dato2.id_kiosco}" name="${dato2.nombre}" value="${dato.nombre}" type="button" class="btn btn-secondary kiosko ml-2"><i class="fas fa-plug text-danger mr-1"></i>${dato2.nombre}</button>
                        </c:if>
                      </c:if>
                    </c:forEach>
                  </div>
                </c:forEach>
              </div>
          </div>
          <!--Termina código de barra lateral de kioskos-->

          <!--Inicia código de pantalla Monitoreo sin selección-->
          <div id="vistaSeleccion" class="col-md-10">
            <div class="container text-center bg-info text-white">
              <h1 class="my-5 py-5">Aún nada seleccionado</h1>
            </div>
          </div>
          <!--Termina código de pantalla Monitoreo sin selección-->

          <!--Inicia código de la vista de la agencia-->
          <div id="vistaAgencia" class="col-md-10 collapse" >

          </div>
          <!--Termina código de la vista de Agencia-->

          <!--Inicia código de la vista de Kioskos-->
          <div id="vistaKiosko" class="col-md-10 collapse">
          </div>
        </div>
      </div>

      <footer>
        <div class="container mt-4 mb-5">
          <!--Aquí se encuentran las opciones que pueden salir, solo deben manadarse a llamar-->
          <a id="conectado"><a class="font-weight-bold">Servidor central (192.168.1.139):</a><a class="font-weight-bold text-success ml-5">Conectado <i class="fas fa-desktop"></i></a></a>
          <br>
          <!--<a id="desconectado" class=""><a class="font-weight-bold">Servidor central (192.168.1.139):</a><a class="font-weight-bold text-danger ml-5">Desconectado <i class="fas fa-times"></i></i></a></a>-->
        </div>
      </footer>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
    <script defer src="https://use.fontawesome.com/releases/v5.0.12/js/all.js" integrity="sha384-Voup2lBiiyZYkRto2XWqbzxHXwzcm4A5RfdfG6466bu5LqjwwrjXCMBQBLMWh7qR" crossorigin="anonymous"></script>
    <script src="${jquery}"></script>
    <script src="${btJS}"></script>
    <script src="${alertifyJS}"></script>
    <script src="${spinnerJS}"></script>
    <script src="${homeJS}"></script>
    <script src="${menuJS}"></script>
    <script src="${AJAX}"></script>
    <script src="${mainuJS}"></script>

    </body>

</html>
