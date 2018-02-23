'use strict';

/**
 * @ngdoc function
 * @name clientApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the clientApp
 */
angular.module('clientApp')
  .controller('AboutCtrl', function () {
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
    
  });
