'use strict';

/**
 * @ngdoc function
 * @name clientApp.controller:StatsCtrl
 * @description
 * # StatsCtrl
 * Controller of the clientApp
 */
angular.module('clientApp')
  .controller('StatsCtrl', function ($scope, $http, $location) {
    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];

    $scope.stagione = "Stagione";
    $scope.showTable = false;

    $scope.jsonResp = [{}];
	$scope.host = location.host;

	$scope.f0001 = function() { $scope.stagione = "0001"; }
	$scope.f0102 = function() { $scope.stagione = "0102"; }
	$scope.f0203 = function() { $scope.stagione = "0203"; }
	$scope.f0304 = function() { $scope.stagione = "0304"; }
	$scope.f0405 = function() { $scope.stagione = "0405"; }
	$scope.f0506 = function() { $scope.stagione = "0506"; }
	$scope.f0607 = function() { $scope.stagione = "0607"; }
	$scope.f0708 = function() { $scope.stagione = "0708"; }
	$scope.f0809 = function() { $scope.stagione = "0809"; }
	$scope.f0910 = function() { $scope.stagione = "0910"; }

	$scope.getStats = function() {

		var resp = $http.get("http://" + $location.host() + ":8080" + "/api/stats/" + $scope.stagione);


		resp.then(function(response) {
	      	console.log('ok!');
	      	console.log(response);
	      	console.log(response.data[0]);
	      	$scope.jsonResp = response.data
	      	$scope.showTable = true;
	      	$scope.esitoE = false;
	      	$scope.insPersonaSuccess = "Persona inerita con successo"
	      	console.log($location.host());
	    });

	    resp.catch(function(response) {
            console.log(response);
	    	$scope.rispostaJson = response || "request failed";
	    	$scope.showTable = false;
	    });

	}



  });
