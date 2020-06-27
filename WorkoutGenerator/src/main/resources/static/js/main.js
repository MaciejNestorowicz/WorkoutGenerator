$(document).ready(function(){

    $('.nBtn').on('click', function(event){
        var id = $(this).data("workoutunit");
        $('#submitExerciseButton').data('workoutId', id);
            $('.myForm #exampleModal').modal();
    });

    $('#submitExerciseButton').on('click', function(event){
        var id = $('#submitExerciseButton').data('workoutId');
        var exercise = {};
            exercise.name = $('#name').val();
            exercise.sets = $('#sets').val();
                if(!$.isNumeric(exercise.sets)){
                alert("value of sets must be a number");
                return false;
                }
            exercise.reps = $('#reps').val();
                if(!$.isNumeric(exercise.reps)){
                alert("value of reps must be a number");
                return false;
                }
            exercise.weight = $('#weight').val();
                if(!$.isNumeric(exercise.weight)){
                alert("value of weight must be a number");
                return false;
                }
        var exerciseObj = JSON.stringify(exercise);

            $.ajax({
                type: 'POST',
                url: "/save/"+id,
                contentType: "application/json; charset=utf-8",
                data: exerciseObj,
                success: function(){
                        window.location.reload(true);
                    },
                    error: function(XMLHttpRequest, textStatus, errorThrown) {
                        console.log(textStatus, errorThrown);
                    }
            });
    });

    $('.table .delBtn').on('click', function(event){
        event.preventDefault();
        var href = $(this).attr('href');
        $('#myModal #delRef').attr('href', href );
        $('#myModal').modal();
    });

        $('.table .delWoUnBtn').on('click', function(event){
            event.preventDefault();
            var href = $(this).attr('href');
            $('#myModal #delRef').attr('href', href );
            $('#myModal').modal();
        });
});