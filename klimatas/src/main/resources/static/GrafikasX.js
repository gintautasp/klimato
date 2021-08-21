

		function GrafikasX ( id_canvas, reiksmes, x_koord_pav, y_koord_pav ) {
		
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
			
			
			this.min_y = reiksmes [ 0 ] [ y_koord_pav ];
			max_y = reiksmes [ 0 ] [ y_koord_pav ];
			
			this.min_x = reiksmes [ 0 ] [ x_koord_pav ];
			max_x = reiksmes [ 0 ] [ x_koord_pav ];
			
			for ( i = 1; i < reiksmes.length; i++ ) {
			
				if ( this.min_y > reiksmes [ i ] [ y_koord_pav ] ) {
					
					this.min_y = reiksmes [ i ] [ y_koord_pav ];
				}
				if ( max_y < reiksmes [ i ] [ y_koord_pav ] ) {
					
					max_y = reiksmes [ i ] [ y_koord_pav ];
				}
				if ( this.min_x > reiksmes [ i ] [ x_koord_pav ] ) {
					
					this.min_x = reiksmes [ i ] [ x_koord_pav ];
				}
				if ( max_x	< reiksmes [ i ] [ x_koord_pav ] ) {
					
					max_x = reiksmes [ i ] [ x_koord_pav ];
				}
			}
			
			this.y_range = max_y - this.min_y;	
			console.log ( "min_y: " + this.min_y + " max_y: " + max_y  + " this.y_range: " + this.y_range );			
			this.x_range = max_x - this.min_x;	
			
			y_grid_dy = ( this.y_height - 20 ) / 4;
			
			y_grid_val_dy = ( max_y - this.min_y ) / 4;
			y_grid_val = this.min_y;
			console.log ( "min_y: " + this.min_y + " max_y: " + max_y  + " y_grid_val_dy: " + y_grid_val_dy );
			
			
			x_grid_dx = this.x_width / 4;
			x_grid_val_dx = ( max_x - this.min_x ) / 4;
			x_grid_val = this.min_x;			
																																									// Vertikalios
			for ( i = 0; i < 5; i++ ) {
			 
				this.ctx.moveTo ( this.x_koord_prad + x_grid_dx * i, this.x_koord_prad - 10 );
				this.ctx.lineTo ( this.x_koord_prad + x_grid_dx * i, this.y_koord_prad );
			 
				this.ctx.fillText( x_grid_val, this.x_koord_prad + x_grid_dx * i,/* x_koord_prad - 10, x_koord_prad + x_grid_dx * i,*/ this.y_koord_prad );
				x_grid_val += x_grid_val_dx;
			}
																																									//Horizontalios
			for ( i = 0; i < 5; i++ ) {
			
				this.ctx.moveTo ( this.x_koord_prad, this.y_koord_prad - y_grid_dy * i );
				this.ctx.lineTo ( this.x_koord_prad + this.x_width, this.y_koord_prad - y_grid_dy * i );
			
				this.ctx.fillText (  y_grid_val, this.x_koord_prad, this.y_koord_prad - y_grid_dy * i );
				y_grid_val += y_grid_val_dy;
				console.log ( "y_grid_val: " + y_grid_val );
			}
			
			this.braizom = function( reiksmes, x_koord_pav, y_koord_pav, spalva ) {
		
				this.ctx.beginPath();
				this.ctx.strokeStyle = spalva;				

				go_to_start = true;
				
				for ( i = 0; i < reiksmes.length; i++ ) {
					
					x_koord = this.x_koord_prad + ( ( reiksmes [ i ] [ x_koord_pav ] - this.min_x ) / this.x_range ) * this.x_width;
					
					y_koord = this.y_koord_prad - ( ( reiksmes [ i ] [ y_koord_pav ] - this.min_y ) / this.y_range ) * ( this.y_height - 20 );
					
					console.log ( "x: " + x_koord.toFixed( 2 ) + " y: " + y_koord.toFixed ( 2 )  + " : " + ( reiksmes [ i ] [ y_koord_pav ] ) + " : " +  ( reiksmes [ i ] [ y_koord_pav ] - this.min_y )   );
				
					
					if ( go_to_start ) {
					
						this.ctx.moveTo ( x_koord, y_koord );
						go_to_start = false;
						
					} else {
					
						this.ctx.lineTo ( x_koord,  y_koord );
					}
				}	
				this.ctx.stroke();
				this.ctx.closePath();	
			}
		}