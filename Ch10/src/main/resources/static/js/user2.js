/**
 * User2
 */

			$(function(){
				
				$('#btnUser2s').click(function(){
					$.ajax({
						url: '/Ch10/user2',
						type:'GET',
						dataType:'json', 
						success:function(data){
							console.log(data);
						}
					})
				});
				
				$('#btnUser2').click(function(){
						$.ajax({
						url: '/Ch10/user2/A105',
						type:'GET',
						dataType:'json', 
						success:function(data){
							console.log(data);
						}
					})
					
				});
				
				$('#btnUser2Register').click(function(){
				
					const jsonData ={
						id:'A106',
						name: '이기자',
						hp: '010-1111-1551',
						age: 22
					};	
					$.ajax({
						url: '/Ch10/user2',
						type:'POST',
						data:jsonData,
						dataType:'json', 
						success:function(data){
							console.log(data);
						}
					})
					
				});
				
				$('#btnUser2Modify').click(function(){
					
						const jsonData ={
							id:'A104',
							name: '강감찬',
							hp: '010-1234-7896',
							age: 35
						};	
						$.ajax({
						url: '/Ch10/user2',
						type:'PUT',
						data:jsonData,
						dataType:'json', 
						success:function(data){
							console.log(data);
						}
					})
					
				});
				
				$('#btnUser2Delete').click(function(){
					$.ajax({
						url: '/Ch10/user2/A101',
						type:'DELETE',
						dataType:'json', 
						success:function(data){
							console.log(data);
						}
						});
				});
			
			});	
				