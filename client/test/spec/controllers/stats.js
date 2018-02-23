'use strict';

describe('Controller: StatsCtrl', function () {

  // load the controller's module
  beforeEach(module('clientApp'));

  var StatsCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    StatsCtrl = $controller('StatsCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(StatsCtrl.awesomeThings.length).toBe(3);
  });
});
