    $(document).ready(function () {
        // 전체약관동의 체크박스 클릭 시
        $(".agreebox1 input[type='checkbox']").change(function () {
            if ($(this).is(":checked")) {
                // 전체약관동의가 체크된 경우 모든 하위 체크박스 체크
                $(".agreebox2 input[type='checkbox'], .agreebox3 input[type='checkbox']").prop('checked', true);
            } else {
                // 전체약관동의가 해제된 경우 모든 하위 체크박스 해제
                $(".agreebox2 input[type='checkbox'], .agreebox3 input[type='checkbox']").prop('checked', false);
            }
        });

        // 하위 체크박스 중 하나라도 해제될 경우 전체약관동의 체크 해제
        $(".agreebox2 input[type='checkbox'], .agreebox3 input[type='checkbox']").change(function () {
            if (!$(this).is(":checked")) {
                $(".agreebox1 input[type='checkbox']").prop('checked', false);
            }
        });
    });

    $(document).ready(function(){
        $("form").on("submit", function(event){
            event.preventDefault();

            if(!$('.agreebox2 input[type="checkbox"]').is(':checked')){
                alert('필수 약관동의가 필요합니다.');
                return;
            }

            var formData = $(this).serialize();
            $.ajax({
                url: '/member/join',
                type: 'POST',
                data: formData,
                success: function(data) {
                    alert(data.message);
                    if (data.status === 'success') {
                        window.location.href = "/main";
                    }
                },
                error: function(error) {
                    console.error(error);
                }
            });
        });
    });