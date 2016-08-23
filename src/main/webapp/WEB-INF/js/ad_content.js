	var adApp = angular.module('adApp', []);
	adApp.controller('RetrieveAllAdsController', function($scope, $http) {
		$scope.retrieveAdContent = function() {
			$http.get('http://localhost:8080/ad_manager/ad').success(
					function(data) {
						$scope.ads = data;
					});
		};
	});
	
	adApp.controller('RetrieveAdController', function($scope, $http) {
		$scope.retrieveAdContent = function(partner_id) {
			$http.get('http://localhost:8080/ad_manager/ad/' + partner_id)
			.success(function(data) {
						$scope.retrieveAd = data;
					})
			.error(function(data) {
						$scope.retrieveAdMessage = "No data found for the partner_id " + partner_id;
					});
		};
	});
	
	adApp.controller('DeleteAdController', function($scope, $http) {
		$scope.deleteAdContent = function(partner_id) {
			$http.delete('http://localhost:8080/ad_manager/ad/' + partner_id)
			.success(function(data) {
						$scope.deleteAdMessage = "Ad deleted successfully!";
					})
			.error(function(data) {
						$scope.deleteAdMessage = "Unable to delete Ad for partner_id " + partner_id;
					});
		};
	});

	adApp.controller('CreateAdController', function($scope, $http) {
		$scope.createAdContent = function() {
			$http.post('http://localhost:8080/ad_manager/ad', {
				'partner_id' : $scope.partner_id,
				'duration' : $scope.duration,
				'ad_content' : $scope.ad_content
				})
				.success(function(response) {
					$scope.message = "Ad Created Successfully!";
				})
				.error(function(response) {
					$scope.message = "Unable to create ad. All fields are mandatory!";
				});
		};
	});