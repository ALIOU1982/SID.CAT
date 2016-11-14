var app = angular.module("MyCat", []);

app.controller("CatController", function($scope, $http){
	$scope.produits=[];
	$scope.prod=[];
	$scope.produitClients=[];
	$scope.clients=[];
	$scope.motCle=null;
	$scope.PageCourante=0;

	$scope.listeClients=function(){
		$http.get("/allClient")
		.success(function(data){
			$scope.clients=data;
		});
	};
	
	$scope.listeProduit=function(value){
		$scope.Id= null;
		    $scope.Id= value;
		    $http.get("/ProduitParClient?id="+$scope.Id)
		    .success(function(data){
			$scope.produitClients=data;
		});
	};
	
	$scope.enregistrer = function(){
		$http.get("/save?designation="+$scope.designe+"&Prix="+$scope.prixp+"&client="+$scope.idclient)
		.success(function(data){
			$scope.prod=data;
			$scope.myForm.submitted=true;
		});
	};
	
	$scope.enregistrerClient = function(){
		$http.get("/saveClient?adrresse="+$scope.adresseclient+"&nom="+$scope.nomclient+"&Prenom="+$scope.prenomclient)
		.success(function(data){
			$scope.prod=data;
		})
	};
	
	$scope.charger=function(){
		$http.get("/produitsParMC?mc="+$scope.motCle+"&page="+$scope.PageCourante)
		.success(function(data){
			$scope.produits=data.content;
			$scope.pages= new Array(data.totalPages);
		});		
	};
	
	$scope.gotoPage=function(p){
		$scope.PageCourante=p;
		$scope.charger();
	};
});