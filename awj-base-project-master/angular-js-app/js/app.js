var app = angular.module('blog', [ ]);

+app.controller('HomeController', ['$scope', '$http', function($scope, $http) {
    $scope.helloWorld = 'Aplicatii Web cu suport Java!';
  
  var url = "http://localhost:8080/persoana";
   $scope.persoane = [];
   $scope.keys = [];
	$scope.obj={};
   $scope.person = {};
   $scope.editPerson = {};
 
 
 
   $http.get('http://localhost:8080/persoana').then(
     function successCallback(response) {
		$scope.obj=response;
     $scope.persoane = $scope.obj.data;
     $scope.keys = Object.keys(response.data[0]);
   });
 
 
   $scope.addPersoana = function(persoana) {
        persoana.id = parseInt(persoana.id);
        console.log(persoana.id);
        $http({
            method: 'POST',
            url: url,
            data: persoana
        }).then(function successCallback(response) {
            console.log(response);
            $scope.persoane.push(persoana);
            // done.
        }, function errorCallback(response) {
            console.log(response);
        });
    };


    $scope.deletePersoana = function(id) {
        $http({
            method: 'DELETE',
            url: url+'/' + id,
            data: {}
        }).then(function successCallback(response) {
            // aici nu intra niciodata ca e functia de succes
        }, function errorCallback(response) {
            // aici intra pentru ca da eroare
            $scope.persoane = $scope.persoane.filter(function(obj) {
                return obj.id !== id;
            });
        });
    };



    $scope.setUpdatePerson = function(person) {
        $scope.editPerson = person;
    };


    $scope.updatePerson = function() {
        $http({
            method: 'PUT',
            url: url,
            data: $scope.editPerson
        }).then(function successCallback(response) {
            $scope.editPerson = {};
            console.log(response);
            // $scope.persoane.push($scope.editPerson);
            // done.
        }, function errorCallback(response) {
            $scope.editPerson = {};
            console.log(response);
        });
    };
    
    
  }]);

+app.controller('StudentController', ['$scope', '$http', function($scope, $http){
    
    //Student
    
    var url = "http://localhost:8080/student";
   $scope.studenti = [];
   $scope.keys = [];
	$scope.obj={};
   $scope.student = {};
   $scope.editStudent = {};
 
 
 
   $http.get('http://localhost:8080/student').then(
     function successCallback(response) {
		$scope.obj=response;
     $scope.studenti = $scope.obj.data;
     $scope.keys = Object.keys(response.data[0]);
   });
 
 
   $scope.addStudent = function(student) {
        student.id = parseInt(student.id);
        console.log(student.id);
        $http({
            method: 'POST',
            url: url,
            data: student
        }).then(function successCallback(response) {
            console.log(response);
            $scope.studenti.push(student);
            // done.
        }, function errorCallback(response) {
            console.log(response);
        });
    };


    $scope.deleteStudent = function(id) {
        $http({
            method: 'DELETE',
            url: url+'/' + id,
            data: {}
        }).then(function successCallback(response) {
            // aici nu intra niciodata ca e functia de succes
        }, function errorCallback(response) {
            // aici intra pentru ca da eroare
            $scope.studenti = $scope.studenti.filter(function(obj) {
                return obj.id !== id;
            });
        });
    };


    $scope.setUpdateStudent = function(student) {
        $scope.editStudent = student;
    };


    $scope.updateStudent = function() {
        $http({
            method: 'PUT',
            url: url,
            data: $scope.editStudent
        }).then(function successCallback(response) {
            $scope.editStudent = {};
            console.log(response);
            // $scope.persoane.push($scope.editPerson);
            // done.
        }, function errorCallback(response) {
            $scope.editStudent = {};
            console.log(response);
        });
    };
    
  }]);

+app.controller('WishController', ['$scope', '$http', function($scope, $http){
    
    //Wish
    
     var url = "http://localhost:8080/wish";
   $scope.wishes = [];
   $scope.keys = [];
	$scope.obj={};
   $scope.wish = {};
   $scope.editWish = {};
 
 
 
   $http.get('http://localhost:8080/wish').then(
     function successCallback(response) {
		$scope.obj=response;
     $scope.wishes = $scope.obj.data;
     $scope.keys = Object.keys(response.data[0]);
   });
 
 
   $scope.addWish = function(wish) {
        wish.id = parseInt(wish.id);
        console.log(wish.id);
        $http({
            method: 'POST',
            url: url,
            data: wish
        }).then(function successCallback(response) {
            console.log(response);
            $scope.wishes.push(wish);
            // done.
        }, function errorCallback(response) {
            console.log(response);
        });
    };


    $scope.deleteWish = function(id) {
        $http({
            method: 'DELETE',
            url: url+'/' + id,
            data: {}
        }).then(function successCallback(response) {
            // aici nu intra niciodata ca e functia de succes
        }, function errorCallback(response) {
            // aici intra pentru ca da eroare
            $scope.wishes = $scope.wishes.filter(function(obj) {
                return obj.id !== id;
            });
        });
    };


    $scope.setUpdateWish = function(wish) {
        $scope.editWish = wish;
    };


    $scope.updateWish = function() {
        $http({
            method: 'PUT',
            url: url,
            data: $scope.editWish
        }).then(function successCallback(response) {
            $scope.editWish = {};
            console.log(response);
            // $scope.persoane.push($scope.editPerson);
            // done.
        }, function errorCallback(response) {
            $scope.editWish = {};
            console.log(response);
        });
    };
    
  }]);

+app.controller('FoodController', ['$scope', '$http', function($scope, $http){
    
    //Food
    
   var url = "http://localhost:8080/food";
   $scope.foods = [];
   $scope.keys = [];
	$scope.obj={};
   $scope.food1 = {};
   $scope.editFood = {};
 
 
 
   $http.get('http://localhost:8080/food').then(
     function successCallback(response) {
		$scope.obj=response;
     $scope.foods = $scope.obj.data;
     $scope.keys = Object.keys(response.data[0]);
   });
 
 
   $scope.addFood = function(food) {
        food.id = parseInt(food.id);
        console.log(food.id);
        $http({
            method: 'POST',
            url: url,
            data: food
        }).then(function successCallback(response) {
            console.log(response);
            $scope.foods.push(food);
            // done.
        }, function errorCallback(response) {
            console.log(response);
        });
    };


    $scope.deleteFood = function(id) {
        $http({
            method: 'DELETE',
            url: url+'/' + id,
            data: {}
        }).then(function successCallback(response) {
            // aici nu intra niciodata ca e functia de succes
        }, function errorCallback(response) {
            // aici intra pentru ca da eroare
            $scope.foods = $scope.foods.filter(function(obj) {
                return obj.id !== id;
            });
        });
    };


    $scope.setUpdateFood = function(food1) {
        $scope.editFood = food1;
    };


    $scope.updateFood = function() {
        $http({
            method: 'PUT',
            url: url,
            data: $scope.editFood
        }).then(function successCallback(response) {
            $scope.editFood = {};
            console.log(response);
            // $scope.persoane.push($scope.editPerson);
            // done.
        }, function errorCallback(response) {
            $scope.editFood = {};
            console.log(response);
        });
    };
    
  }]);