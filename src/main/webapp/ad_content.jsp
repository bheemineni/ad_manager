<!doctype html>
<html ng-app='adApp'>
<head>
<title>Hello Angular</title>
<script	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js"></script>
	
<script type="text/javascript">
	<%@include file="WEB-INF/js/ad_content.js" %>
</script>
	
<style>
	table, th, td {
		border: 1px solid grey;
		border-collapse: collapse;
		padding: 5px;
	}
	
	table tr:nth-child(odd) {
		background-color: #f1f1f1;
	}
	
	table tr:nth-child(even) {
		background-color: #ffffff;
	}
	
	b {
		color:red
	}
</style>

</head>

<body>

	<hr />
	<div ng-controller="RetrieveAllAdsController" ng-init="retrieveAdContent()">
		<h2>Available Ads</h2>

		<div ng-hide="ads.length">
			<b>There are no ads available now.</b>
		</div>
		<div ng-show="ads.length">
			<h5>Number of ads available: {{ads.length}}</h5>
		</div>

		<table>
			<tr ng-repeat="ad in ads | orderBy : 'partner_id'">
				<td>{{ad.partner_id}}</td>
				<td>{{ad.duration}}</td>
				<td>{{ad.ad_content}}</td>
			</tr>
		</table>
	</div>
	<hr />

	<div ng-controller="CreateAdController">
		<form action="javascript:void(0);">
			<h2>Create New Ad</h2>
			<div>
				<label>Partner Id</label> <input type="text" ng-model="partner_id"
					placeholder="Unique Id Of Partner" required="required"
					style='margin-left: 10px;'>
			</div>
			<div>
				<label>Ad Duration (Sec)</label> <input type="text"
					ng-model="duration" placeholder="Ad Duration From Now"
					required="required" email="duration" style='margin-left: 10px;'>
			</div>
			<div>
				<label>Ad Content</label> <input type="ad_content"
					ng-model="ad_content" placeholder="Content To Display As Ad">
			</div>
			<button ng-click='createAdContent()' style='margin-top: 15px'>Create
				Ad</button>
			<button type="reset" value="Reset">Reset</button>

			<b>{{message}}</b>

		</form>
	</div>
	<hr />
	
	<div ng-controller="RetrieveAdController">
		<form action="javascript:void(0);">
			<h2>Retrieve Ad</h2>
			<div>
				<label>Partner Id</label> <input type="text" ng-model="partner_id"
					placeholder="Unique Id Of Partner" required="required"
					style='margin-left: 10px;'>
			</div>
			<button ng-click='retrieveAdContent(partner_id)' style='margin-top: 15px'>Retrieve
				Ad</button>
			<button type="reset" value="Reset">Reset</button>
			
			<b>{{retrieveAdMessage}}</b>

		</form>
		
		<div ng-show="retrieveAd"> 
			<ul> 
				<li>{{retrieveAd.partner_id}}</li>
				<li>{{retrieveAd.duration}}</li>
				<li>{{retrieveAd.ad_content}}</li>
			</ul>
		</div>
	</div>
	<hr />
	
	<div ng-controller="DeleteAdController">
		<form action="javascript:void(0);">
			<h2>Delete Ad</h2>
			<div>
				<label>Partner Id</label> <input type="text" ng-model="partner_id"
					placeholder="Unique Id Of Partner" required="required"
					style='margin-left: 10px;'>
			</div>
			<button ng-click='deleteAdContent(partner_id)' style='margin-top: 15px'>Delete
				Ad</button>
			<button type="reset" value="Reset">Reset</button>
			
			<b>{{deleteAdMessage}}</b>
		</form>
	</div>
	<hr />
	
</body>
</html>