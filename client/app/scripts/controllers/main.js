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

 	$scope.stagione = "Stagione";
 	$scope.partita = "Partita";

 	$scope.settore    = "Settore";
 	$scope.anello     = "Anello";
 	$scope.posto      = "";
 	$scope.spettatore = "";
 	$scope.compratore = "";
 	$scope.btn = "GO!";


 	$scope.cf = "";

 	$scope.my = { message: false };

 	$scope.esito = false;
 	$scope.esitoS = false;
 	$scope.esitoE = false;

 	$scope.takeShort = function() {


 		var respSeEsiste = $http.get("http://" + $location.host() + ":8080" + "/api/esiste/" + 
 			$scope.partita + "/" + $scope.stagione + "/" + $scope.posto + "/" + $scope.anello + "/" + $scope.settore);
 		
 		respSeEsiste.then(function(response) {
 			console.log('Inserted!');
 			$scope.occupato = false;
 			console.log(response.data);
 			if(response.data){
 				$scope.occupato = true ;
 			}
 		});

 		respSeEsiste.catch(function(response) {
 			console.log(response);
 		});

 		/*=============================================================================*/

 		var respIsPassholder = $http.get("http://" + $location.host() + ":8080" + "/api/persona/" + $scope.compratore);
 		respIsPassholder.then(function(response) {
 			console.log('eeeeeee!');
 			$scope.occupato = false;
 			console.log(response.data.tipo);
 			if(response.data.tipo == "SPETTATORE"){
 				$scope.compratoreIsSpettatore = true ;
 			}
 		});
 		respIsPassholder.catch(function(response) {
 			console.log(response);
 		});

 		/*=============================================================================*/


 		var res = $http.post("http://" + $location.host() + ":8080" + "/api/biglietto", {
 			stagione:$scope.stagione, 
 			partita: $scope.partita, 
 			settore:$scope.settore, 
 			anello:$scope.anello, 
 			posto:$scope.posto, 
 			spettatore:$scope.spettatore, 
 			compratore:$scope.compratore
 		});


 		res.then(function(response) {
 			console.log('Inserted!');
 			console.log(response.data);
 			console.log(response.data.prezzoTotale);
 			$scope.prezzo = response.data.prezzoTotale;
 			$scope.settore    = "Settore";
 			$scope.anello     = "Anello";
 			$scope.posto      = "";
 			$scope.spettatore = "";
 			$scope.compratore = "";
 			$scope.rispostaJson = response;
 			$scope.my.message = true;
 			$scope.esito =  "Inserimento avvenuto con successo - Prezzo: " + $scope.prezzo + "€";
 			console.log($location.host());
 			$scope.err = "";
 		});

 		res.catch(function(response) {
 			console.log(response);
 			$scope.rispostaJson = response || "request failed";
 			$scope.err = true ;



 			if($scope.occupato){ 
 				$scope.esito = "Posto Occupato";
 			} else if($scope.compratoreIsSpettatore){
 				$scope.esito = "Il compratore non è registrato al Club";
 			} else if ($scope.settore  == "" || $scope.anello == "" || $scope.posto == "" || $scope.spettatore == "" || $scope.compratore == "") {
 				$scope.esito = "Inserire tutti i campi";
 			} else {
 				$scope.esito = "Errore";
 			}
 		});
 	};

 	/*=============================================================================*/

 	$("button").click(function(){
 		$("button").removeClass("btn-success");
 		$(this).addClass("btn-success");
 	});

 	$scope.levelOU = function() {
 		$scope.tipo = "SPETTATORE";
 		console.log($scope.tipo);
 	}

 	$scope.levelCD = function() {
 		$scope.tipo = "PASSHOLDER";
 		console.log($scope.tipo);
 	}


 	$scope.fSettore001 = function() { $scope.settore = "001"; }
 	$scope.fSettore002 = function() { $scope.settore = "002"; }
 	$scope.fSettore003 = function() { $scope.settore = "003"; }
 	$scope.fSettore004 = function() { $scope.settore = "004"; }
 	$scope.fSettore005 = function() { $scope.settore = "005"; }
 	$scope.fSettore006 = function() { $scope.settore = "006"; }
 	$scope.fSettore007 = function() { $scope.settore = "007"; }
 	$scope.fSettore008 = function() { $scope.settore = "008"; }
 	$scope.fSettore009 = function() { $scope.settore = "009"; }
 	$scope.fSettore010 = function() { $scope.settore = "010"; }

 	$scope.fAnello001 = function() { $scope.anello = "001"; }
 	$scope.fAnello002 = function() { $scope.anello = "002"; }
 	$scope.fAnello003 = function() { $scope.anello = "003"; }
 	$scope.fAnello004 = function() { $scope.anello = "004"; }
 	$scope.fAnello005 = function() { $scope.anello = "005"; }

 	$scope.fStagione0001 = function() { $scope.stagione = "0001"; }
 	$scope.fStagione0102 = function() { $scope.stagione = "0102"; }
 	$scope.fStagione0203 = function() { $scope.stagione = "0203"; }
 	$scope.fStagione0304 = function() { $scope.stagione = "0304"; }
 	$scope.fStagione0405 = function() { $scope.stagione = "0405"; }
 	$scope.fStagione0506 = function() { $scope.stagione = "0506"; }
 	$scope.fStagione0607 = function() { $scope.stagione = "0607"; }
 	$scope.fStagione0708 = function() { $scope.stagione = "0708"; }
 	$scope.fStagione0809 = function() { $scope.stagione = "0809"; }
 	$scope.fStagione0910 = function() { $scope.stagione = "0910"; }

 	$scope.fPartita1 = function() { $scope.partita = 1; }
 	$scope.fPartita2 = function() { $scope.partita = 2; }
 	$scope.fPartita3 = function() { $scope.partita = 3; }
 	$scope.fPartita4 = function() { $scope.partita = 4; }
 	$scope.fPartita5 = function() { $scope.partita = 5; }
 	$scope.fPartita6 = function() { $scope.partita = 6; }
 	$scope.fPartita7 = function() { $scope.partita = 7; }
 	$scope.fPartita8 = function() { $scope.partita = 8; }
 	$scope.fPartita9 = function() { $scope.partita = 9; }
 	$scope.fPartita10 = function() { $scope.partita = 10; }
 	$scope.fPartita11 = function() { $scope.partita = 11; }
 	$scope.fPartita12 = function() { $scope.partita = 12; }
 	$scope.fPartita13 = function() { $scope.partita = 13; }
 	$scope.fPartita14 = function() { $scope.partita = 14; }
 	$scope.fPartita15 = function() { $scope.partita = 15; }
 	$scope.fPartita16 = function() { $scope.partita = 16; }
 	$scope.fPartita17 = function() { $scope.partita = 17; }
 	$scope.fPartita18 = function() { $scope.partita = 18; }
 	$scope.fPartita19 = function() { $scope.partita = 19; }

 	/*=============================================================================*/


 	$scope.inserisciPersona = function() {

 		if( ! ($scope.tipo == "PASSHOLDER" || $scope.tipo == "SPETTATORE") ){

 			console.log('Inserire tipo!');
 			$scope.esitoE = true;
 			$scope.insPersonaErr = "Inserire tipo";
 			return;
 		} else if($scope.cf == "") {
 			console.log('Inserire cf!');
 			$scope.esitoE = true;
 			$scope.insPersonaErr = "Inserire cf";
 			return;
 		}


 		var resp = $http.post("http://" + $location.host() + ":8080" + "/api/persona", {
 			cf: $scope.cf, 
 			tipo: $scope.tipo, 
 			nome: $scope.nome, 
 			cognome: $scope.cognome, 
 			data_nascita: [
 			Number($scope.anno),
 			Number($scope.mese),
 			Number($scope.giorno),
 			],
 			luogo_nascita:$scope.luogoNascita, 
 			telefono:$scope.telefono
 		});


 		resp.then(function(response) {
 			console.log('Inserted!');
 			$scope.cf  = "";
 			$scope.tipo = "";
 			$scope.nome = "";
 			$scope.cognome = "";
 			$scope.anno = "";
 			$scope.mese = "";
 			$scope.giorno = "";
 			$scope.luogoNascita = "";
 			$scope.telefono = "";
 			$scope.esitoS = true;
 			$scope.esitoE = false;
 			$scope.insPersonaSuccess = "Persona inerita con successo"
 			console.log($location.host());
 			$scope.err = "";
 			$scope.err = "";
 		});

 		resp.catch(function(response) {
 			console.log(response);
 			$scope.rispostaJson = response || "request failed";
 			$scope.esitoE = true;
 			$scope.erro = true ;
 			if( ! ($scope.tipo == "PASSHOLDER" || $scope.tipo == "SPETTATORE") ){
 				$scope.insPersonaErr = "Inserire tutti i campi";
 			} else {
 				$scope.insPersonaErr = "Errore";
 			}
 		});


 	};


 });
