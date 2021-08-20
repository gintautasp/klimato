
$( function() {
	var dialog, form,
			
		// From http://www.whatwg.org/specs/web-apps/current-work/multipage/states-of-the-type-attribute.html#e-mail-state-%28type=email%29
		id_miesto = $( "#id_miesto" ),
		metai = $( "#metai" ),
		laikotarpis = $( "#laikotarpis" ),
		temperatura = $( "#temperatura" ),
	
		allFields = $( [] ).add( id_miesto ).add( metai ).add( laikotarpis ).add( temperatura ) ,
		tips = $( ".validateTips" );
	
	function updateTips( t ) {
		tips
		.text( t )
		.addClass( "ui-state-highlight" );
		setTimeout(function() {
		tips.removeClass( "ui-state-highlight", 1500 );
		}, 500 );
	}
	
	function checkLength( o, n, min, max ) {
		if ( o.val().length > max || o.val().length < min ) {
		o.addClass( "ui-state-error" );
		updateTips( + n + " turi būti tarp " +
			min + " bei " + max + "." );
		return false;
		} else {
		return true;
		}
	}
	
	function checkRegexp( o, regexp, n ) {
		if ( !( regexp.test( o.val() ) ) ) {
		o.addClass( "ui-state-error" );
		updateTips( n );
		return false;
		} else {
		return true;
		}
	}
	
	function pridetiKlienta() {
	
		var valid = true;
		allFields.removeClass( "ui-state-error" );
		
			// id pav flag_skirtas_galutiniam_vartojimui vnt_mato kiekis kaina_uz_kiekio_vnt aprasymas
		
	
		//valid = valid && checkLength( pav, "Pavadinimas", 3, 100 );
		//valid = valid && checkLength( kontaktai, "Kontaktai", 1, 255 );           
	
		//valid = valid && checkRegexp( pav, /^[A-ZĄČĘĖĮŠŲŪŽ]([0-9a-ząčęėįšųūž_\s])+$/i, "Varde/Pavadinime turi būti a-z ąčęėįšųūž, 0-9, pabraukimai, tarpai ir turi prasidėti didžąją raide" );   
	
		if ( valid ) {
		
		form.submit();
		dialog.dialog( "close" );
		}
		return valid;
	}
	
	dialog = $( "#data_form" ).dialog({
		autoOpen: false,
		height: 500,
		width: 450,
		modal: true,
		buttons: {
		"Patvirtinti": pridetiKlienta,
		Cancel: function() {
			dialog.dialog( "close" );
		}
		},
		close: function() {
		form[ 0 ].reset();
		allFields.removeClass( "ui-state-error" );
		}
	});
	
	form = dialog.find( "form" );
	
	$( "#kliento-dialogas" ).button().on( "click", function() {
		dialog.dialog( "open" );
	});
	
	});
	
		dialog_msg = $( "#dialog-message" ).dialog({
		autoOpen: false,     
		modal: true,
		buttons: {
		Gerai: function() {
			$( this ).dialog( "close" );
			location.reload();
		}
		}
	});