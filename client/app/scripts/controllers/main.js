'use strict';

/**
 * @ngdoc function
 * @name clientApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the clientApp
 */
angular.module('clientApp')
  .controller('MainCtrl', function ($scope, $http, $location) {
    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];

    $scope.host = location.host;

    $scope.settore    = "";
    $scope.anello     = "";
    $scope.posto      = "";
    $scope.spettatore = "";
    $scope.compratore = "";
    $scope.btn = "GO!";

 	$scope.my = { message: false };

	$scope.esito = false;
	$scope.esitoS = false;
	$scope.esitoE = false;

    $scope.takeShort = function() {
    	var res = $http.post("http://" + $location.host() + ":8080" + "/api/biglietto", {
    		stagione:"0910", 
	      	partita: "1", 
	      	settore:$scope.settore, 
	      	anello:$scope.anello, 
	      	posto:$scope.posto, 
	      	spettatore:$scope.spettatore, 
	      	compratore:$scope.compratore
	    });
  		

		res.then(function(response) {
	      	console.log('Inserted!');
            console.log(response.data.aa);
            $scope.settore    = "";
    		$scope.anello     = "";
    		$scope.posto      = "";
    		$scope.spettatore = "";
    		$scope.compratore = "";
	      	$scope.rispostaJson = response;
	      	$scope.my.message = true;
	      	$scope.esito = true;
	      	console.log($location.host());
	        $scope.err = "";
	    });

	    res.catch(function(response) {
            console.log(response);
	    	$scope.rispostaJson = response || "request failed";
	        $scope.err = true ;
	        if( $scope.settore  == "" || $scope.anello == "" || $scope.posto == "" || $scope.spettatore == "" || $scope.compratore == ""){
				$scope.esito = "Inserire tutti i campi";
	        } else {
		        $scope.esito = "Errore";
	        }
	    });
    };


    $scope.inserisciPersona = function() {
    	var resp = $http.post("http://" + $location.host() + ":8080" + "/api/persona", {
    		cf: $scope.cf, 
	      	tipo: $scope.tipo, 
	      	nome: $scope.nome, 
	      	cognome: $scope.cognome, 
	      	data_nascita: [
	      		$scope.anno,
	      		$scope.mese,
	      		$scope.giorno,
	      	],
	      	luogo_nascita:$scope.luogoNascita, 
	      	telefono:$scope.telefono
	    });
  		

		resp.then(function(response) {
	      	console.log('Inserted!');
           /* $scope.cf  = "";
    		$scope.tipo = "";
    		$scope.nome = "";
    		$scope.cognome = "";
    		$scope.anno = "";
	      	$scope.mese = "";
	      	$scope.giorno = "";
	      	$scope.luogoNascita = "";
	      	$scope.telefono = "";*/
	      	$scope.esitoS = true;
	      	console.log($location.host());
	        $scope.err = "";
	        $scope.err = "";
	    });

	    resp.catch(function(response) {
            console.log(response);
	    	$scope.rispostaJson = response || "request failed";
			$scope.esitoE = true;
	        $scope.err = true ;
	        if( true ){
				$scope.esito = "Inserire tutti i campi";
	        } else {
		        $scope.esito = "Errore";
	        }
	    });


    };


});
