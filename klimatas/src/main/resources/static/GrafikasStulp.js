
	function GrafikasStulp ( id_canvas, reiksmes, stulpeliu_pav ) {
		
		cnv = document.getElementById ( id_canvas  );
		
		this.ctx = cnv.getContext ( '2d' );	
		this.ctx.strokeStyle = "purple";
		
		this.x_width = ( cnv.width - 50 );
		this.y_height = ( cnv.height - 50 );
		
		this.x_koord_prad = 30;
		this.y_koord_prad = this.y_height + 20;
		
		console.log ( "x_koord_prad: " + this.x_koord_prad + " y_koord_prad: " + this.y_koord_prad );			
		
		this.ctx.beginPath();
		this.ctx.moveTo ( this.x_koord_prad, 40 );
		this.ctx.lineTo ( this.x_koord_prad, this.y_koord_prad + 5 );
		this.ctx.stroke();
		this.ctx.strokeStyle =  "purple";
		this.ctx.closePath();
		
		this.ctx.beginPath();
		this.ctx.moveTo ( 25, this.y_koord_prad );
		this.ctx.lineTo ( 30 + this.x_width, this.y_koord_prad );
		this.ctx.stroke();
		this.ctx.strokeStyle =  "purple";
		this.ctx.closePath();
		
		this.min_y = reiksmes [ 0 ] [ stulpeliu_pav [ 0 ] ];
		max_y = reiksmes [ 0 ] [ stulpeliu_pav [ 0 ] ];
		
		console.log ( reiksmes );
		
		for ( i = 1; i < reiksmes.length; i++ ) {
			
			for ( j = 0; j < stulpeliu_pav.length; j++ ) {
		
				if ( this.min_y > reiksmes [ i ] [ stulpeliu_pav [ j ] ] ) {
					
					this.min_y = reiksmes [ i ] [ stulpeliu_pav [ j ] ];
				}
				if ( max_y < reiksmes [ i ] [ stulpeliu_pav [ j ] ] ) {
					
					max_y = reiksmes [ i ] [ stulpeliu_pav [ j ] ];
				}
			}
		}
		
		this.y_range = max_y - this.min_y;	
		console.log ( "min_y: " + this.min_y + " max_y: " + max_y  + " this.y_range: " + this.y_range );			
		
		y_grid_dy = ( this.y_height - 20 ) / 4;
		
		y_grid_val_dy = ( max_y - this.min_y ) / 4;
		y_grid_val = this.min_y;
		console.log ( "min_y: " + this.min_y + " max_y: " + max_y  + " y_grid_val_dy: " + y_grid_val_dy );
		
		console.log ( "x_kord_prad",  this.x_koord_prad );
		console.log ( "y_koord_prad", this.x_koord_prad );
		console.log ( 'x_width: ', this.x_width );
		
		this.ctx.beginPath();
		this.ctx.strokeStyle = "yellow";		
																																							//Horizontalios
		for ( i = 0; i < 5; i++ ) {
		
			this.ctx.moveTo ( this.x_koord_prad, this.y_koord_prad - y_grid_dy * i );
			this.ctx.lineTo ( this.x_koord_prad + this.x_width, this.y_koord_prad - y_grid_dy * i );
			
			console.log ( 'this.y_koord_prad - y_grid_dy * i : ', this.y_koord_prad - y_grid_dy * i );
		
			this.ctx.fillText (  y_grid_val, this.x_koord_prad, this.y_koord_prad - y_grid_dy * i );
			y_grid_val += y_grid_val_dy;
			console.log ( "y_grid_val: " + y_grid_val );
		}
		this.ctx.stroke();
		this.ctx.closePath();		
		
		this.braizom = function( reiksmes, stulpeliu_pav,  spalvos ) {
			
			x_koord_dx = this.x_width  / ( reiksmes.length + 1 );
			
			x_koord_dx_j = ( ( 2 * x_koord_dx ) / 3 ) / ( stulpeliu_pav.length + 1 );
			
			// console.log ( 'x_koord_dx : ',  x_koord_dx );
			
			// console.log ( 'x_koord_dx_j : ',  x_koord_dx_j );
			
			// console.log ( 'stulpeliu_pav : ', stulpeliu_pav );
			
			for ( i = 0; i < reiksmes.length; i++ ) {
				
				// console.log( 'i : ', i );
				
				for ( j = 0; j < stulpeliu_pav.length; j++ ) {
					
					// console.log( 'j : ', j );
					
					this.ctx.beginPath();
					this.ctx.strokeStyle = spalvos [ j ];						
				
					x_koord_j = this.x_koord_prad + x_koord_dx *  ( i + 1 ) -  ( x_koord_dx / 3 ) + x_koord_dx_j * j;
					
					y_koord = this.y_koord_prad - ( ( reiksmes [ i ] [ stulpeliu_pav [ j ] ] - this.min_y ) / this.y_range ) * ( this.y_height - 20 );
					
					// console.log ( "x: " + x_koord_j.toFixed( 2 ) + " y: " + y_koord.toFixed ( 2 )  + " : " + ( reiksmes [ i ] [ stulpeliu_pav [ j ]  ] ) + " : " +  ( reiksmes [ i ] [ stulpeliu_pav [ j ] ] - this.min_y )   );
				
					this.ctx.moveTo ( x_koord_j,  this.y_koord_prad );
					this.ctx.lineTo ( x_koord_j,  y_koord );
					
					this.ctx.stroke();
					this.ctx.closePath();						
				}
			}
		}
	}