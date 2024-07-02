<?php
include_once 'set.php';
include_once 'connect.php';

if ($_login == null) {
    header("location:dang-nhap");
}
include('head.php');
?>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Ng�?c Rồng City</title>
    <meta name="description" content="">
    <meta name="author" content="">
    <base href="">
    <meta name="description"
        content="Website chính thức của Chú Bé Rồng Online – Game Bay Vien Ngoc Rong Mobile nhập vai trực tuyến trên máy tính và điện thoại v�? Game 7 Viên Ng�?c Rồng hấp dẫn nhất hiện nay!">
    <meta name="keywords"
        content="Chú Bé Rồng Online,ngoc rong mobile, game ngoc rong, game 7 vien ngoc rong, game bay vien ngoc rong">
    <meta name="twitter:card" content="summary">
    <meta name="twitter:title"
        content="Website chính thức của Chú Bé Rồng Online – Game Bay Vien Ngoc Rong Mobile nhập vai trực tuyến trên máy tính và điện thoại v�? Game 7 Viên Ng�?c Rồng hấp dẫn nhất hiện nay!">
    <meta name="twitter:description"
        content="Website chính thức của Chú Bé Rồng Online – Game Bay Vien Ngoc Rong Mobile nhập vai trực tuyến trên máy tính và điện thoại v�? Game 7 Viên Ng�?c Rồng hấp dẫn nhất hiện nay!">
    <meta name="twitter:image" content="image/1.png">
    <meta name="twitter:image:width" content="200">
    <meta name="twitter:image:height" content="200">
    <link href="assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <script src="assets/jquery/jquery.min.js"></script>
    <script src="assets/notify/notify.js"></script>
    <link rel="icon" href="image/icon.png?v=99">
    <link href="assets/main.css" rel="stylesheet">
</head>

<body>
    <div class="container color-forum pt-1 pb-1">
        <div class="row">
            <div class="col"> <a href="index" style="color: white">Quay lại diễn đàn</a> </div>
        </div>
    </div>
    <div class="container pt-5 pb-5">
        <div class="row">
            <div class="col-lg-6 offset-lg-3">
                <h4>MỞ THÀNH VIÊN - THOAT GAME</h4>
                <?php
                $mysqli = new mysqli("localhost", "root", "", "test");

                if ($mysqli->connect_errno) {
                    echo "Failed to connect to MySQL: (" . $mysqli->connect_errno . ") " . $mysqli->connect_error;
                    exit();
                }
                // Check if account is already activated
                if ($_status == '1') {
                    $_alert = '<div class="text-danger pb-2 font-weight-bold">Tài khoản của bạn đã được kích hoạt<br> Giftcode : city001<br> Giftcode : city002<br> Giftcode : city003<br> Giftcode : city004 </div>';
                }
                // Check if account is not activated and balance is insufficient
                elseif (($_status == '0' || $_status == '-1') && $_coin < 10000) {
                    $_alert = '<div class="text-danger pb-2 font-weight-bold">Bạn không đủ 1 �?ồng. Vui lòng nạp thêm ti�?n vào tài khoản để ' . ($_status == '0' ? 'kích hoạt nhé!' : 'mở lại tài khoản!</div>');
                }
                // Activate or unlock account
                elseif (($_status == '0' || $_status == '-1') && $_coin >= 10000) {
                    $coin = $_coin - 10000;
                    $stmt = $mysqli->prepare('UPDATE account SET active = 1, coin = ? WHERE username = ?');
                    $stmt->bind_param('is', $coin, $_username);
                    if ($stmt->execute() && $stmt->affected_rows > 0) {
                        $_alert = '<div class="text-danger pb-2 font-weight-bold">Kích hoạt tài khoản thành công. <br> Bây gi�? bạn đã có thể đăng nhập vào game!<br> Giftcode : city001<br> Giftcode : city002<br> Giftcode : city003<br> Giftcode : city004 </div>';
                        if ($_status == '-1') {
                            $_alert = '<div class="text-danger pb-2 font-weight-bold">Kích hoạt tài khoản thành công. <br> Bây gi�? bạn đã có thể đăng nhập vào game!<br> Giftcode : city001<br> Giftcode : city002<br> Giftcode : city003<br> Giftcode : city004</div>';
                        }
                    } else {
                        $_alert = '<div class="text-danger pb-2 font-weight-bold">Có lỗi gì đó xảy ra. Vui lòng liên hệ Admin!</div>';
                    }
                } 
                ?>
                <form id="form" method="POST">
                    <div> Thông tin mở thành viên:<br>- Mở thành viên với chỉ <strong>10.000 VND</strong>. <img
                            src="image/hot.gif"><br>- Miễn phí <strong>GiftCode Thành viên</strong>. <img
                            src="image/hot.gif"><br>- Tận hưởng tron vẹn các tính năng. <img src="image/hot.gif"><br>-
                        Xây dựng, ủng hộ ngocrongcity hoạt động. </div>
                    <div id="notify" class="text-danger pb-2 font-weight-bold"></div>
                    <?php if (isset($_POST['submit']))
                        echo $_alert; ?>
                    <button class="btn btn-main form-control" id="btn" type="submit" name="submit">MỞ NGAY</button>
                </form>

            </div>
        </div>
    </div>
    <div class=" border-secondary border-top">
    </div>
    <div class="container pt-4 pb-4 text-white">
            <div class="row">
                <div class="col">
                    <div class="text-center">
                        <div style="font-size: 13px" class="text-dark">
                            <?php
                        echo $_group;
                        echo $_fanpage;
                        echo $_copyright;
                        ?>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="assets/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="assets/main.js"></script>
</body><!-- Bootstrap core JavaScript -->

</html>