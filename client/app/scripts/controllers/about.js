'use strict';

/**
 * @ngdoc function
 * @name clientApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the clientApp
 */
 angular.module('clientApp')
 	.controller('AboutCtrl', function ($scope, $http, $location) {
	 	this.awesomeThings = [
		 	'HTML5 Boilerplate',
		 	'AngularJS',
		 	'Karma'
	 	];

 	$scope.faq = [{
 		key: "Question 1",
 		value: "Answer1"
 	},{
 		key: "Question 2",
 		value: "Answer2"
 	}
 	];

 	$scope.jsonResp = [{}];
 	$scope.host = location.host;

 	$scope.stagione = "Stagione";
 	$scope.partita  = "Partita";
 	$scope.settore  = "Settore";
 	$scope.showTable = false;

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

 	$scope.trovaPresenze = function() {

 		var resp = $http.get("http://" + $location.host() + ":8080" + "/api/presenze/" + $scope.partita + "/" + $scope.stagione + "/" + $scope.settore);

 		resp.then(function(response) {
 			console.log('ok!');
 			console.log(response);
 			$scope.jsonResp = response.data
 			$scope.showTable = true;
 			$scope.esitoE = false;
 			$scope.insPersonaSuccess = "Persona inerita con successo"
 			console.log($location.host());
 		});

 		resp.catch(function(response) {
 			console.log(response);
 			$scope.rispostaJson = response || "request failed";
 			$scope.esitoE = true;
 			$scope.erro = true ;
 		});
 	};
 });
