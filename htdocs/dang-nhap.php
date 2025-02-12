<?php
include_once 'set.php';

$_title = "Ngọc Rồng City - Đăng Nhập";
if ($_login == null) {
    if (isset($_POST['username'])) {

        $username = htmlspecialchars(trim($_POST['username']));
        $password = htmlspecialchars(trim($_POST['password']));

        // Check if input contains invalid characters
        if (!ctype_alnum($username)) {
            $_alert = '<div class="text-danger pb-2 font-weight-bold">Tên đăng nhập chỉ được chứa kí tự và số!</div>';
        } else {
            $select = _fetch(_select("*", 'account', "username='$username'"));

            if ($select != null && $select['password'] == $password) {
                // Kiểm tra xem tài khoản có nhân vật hay chưa dựa trên ID tài khoản
                $account_id = $select['id'];
                $result = _fetch(_select("*", 'player', "`account_id`='$account_id'"));

                if ($result != null) {
                    $_SESSION['account'] = $username;
                    $_SESSION['id'] = $select['id'];
                    header('location:/dien-dan');
                } else {
                    $_alert = '<div class="text-danger pb-2 font-weight-bold">Tài khoản này chưa tạo nhân vật!</div>';
                }
            } else {
                $_alert = '<div class="text-danger pb-2 font-weight-bold">Tên đăng nhập hoặc mật khẩu không hợp lệ, vui lòng kiểm tra lại!</div>';
            }
        }

    } elseif (isset($_POST['submit'])) {
        $_alert = '<div class="text-danger pb-2 font-weight-bold">Vui lòng nhập tên đăng nhập và mật khẩu!</div>';
    }
} else {
    header("location:/");
}
?>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Ngọc Rồng City</title>
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="description"
        content="Website chính thức của Chú Bé Rồng Online – Game Bay Vien Ngoc Rong Mobile nhập vai trực tuyến trên máy tính và điện thoại về Game 7 Viên Ngọc Rồng hấp dẫn nhất hiện nay!">
    <meta name="keywords"
        content="Chú Bé Rồng Online,ngoc rong mobile, game ngoc rong, game 7 vien ngoc rong, game bay vien ngoc rong">
    <meta name="twitter:card" content="summary">
    <meta name="twitter:title"
        content="Website chính thức của Chú Bé Rồng Online – Game Bay Vien Ngoc Rong Mobile nhập vai trực tuyến trên máy tính và điện thoại về Game 7 Viên Ngọc Rồng hấp dẫn nhất hiện nay!">
    <meta name="twitter:description"
        content="Website chính thức của Chú Bé Rồng Online – Game Bay Vien Ngoc Rong Mobile nhập vai trực tuyến trên máy tính và điện thoại về Game 7 Viên Ngọc Rồng hấp dẫn nhất hiện nay!">
    <meta name="twitter:image" content="image/1.png">
    <meta name="twitter:image:width" content="200">
    <meta name="twitter:image:height" content="200">
    <link href="assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <script src="assets/jquery/jquery.min.js"></>
            <script src="assets/notify/notify.js"></script>
    <link rel="icon" href="image/icon.png?v=99">
    <link href="assets/main.css" rel="stylesheet">
</head>

<body>
<div class="container" style="border-radius: 15px; background: #ffaf4c; padding: 0px">
        <div class="container" style="background-color: #e67e22; border-radius: 15px 15px 0px 0px">
            <div class="row bg pb-3 pt-2">
                <div class="col">
                    <div class="text-center mb-2">
                        <a href="../dien-dan"><img class="rounded" src="../image/1.png" id="logo"></a>
                    </div>
                    <div class="text-center pt-2">
                        <div style="display: inline-block;">
                            <a href="../download/City.apk"> <img class="icon-download" src="../image/android.png">
                            </a><br>
                            <small class="text-dark">
                                <?php echo $_android; ?>
                            </small>
                        </div>
                        <div style="display: inline-block;">
                            <a href="../download/City.rar"><img class="icon-download" src="../image/pc.png">
                            </a><br>
                            <small class="text-dark">
                                <?php echo $_windows; ?>
                            </small>
                        </div>
                        <div style="display: inline-block;">
                        <a href="../download/City.ipa"><img class="icon-download" src="../image/ip.png">
						</a><br>
                            <small class="text-dark">
                                <?php echo $_iphone; ?>
                            </small>
                        </div>
                        <div style="display: inline-block;">
                        <a href="https://zalo.me/0343214443"><img class="icon-download" src="../image/zalo.png">
						</a><br>
                            <small class="text-dark">
                                <?php echo $_Zalo; ?>
                            </small>
                        </div>
                        <div>
                            <img height="12" src="image/12.png" style="vertical-align: middle;">
                            <small style="font-size: 10px" id="hour3">Dành cho người chơi trên 12 tuổi. Chơi quá 180
                                phút mỗi ngày sẽ hại sức khỏe.</small>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container color-main2 pb-2">
            <div class="text-center">
                <div class="row">
                    <div class="col pr-0"> <a href="dang-nhap" class="btn p-1 btn-header-active">Đăng
                            nhập</a> </div>
                    <div class="col"> <a href="dang-ky" class="btn p-1 btn-header">Đăng
                            ký</a> </div>
                </div>
            </div>
        </div>
        <div class="container color-forum pt-1 pb-1">
            <div class="row">
                <div class="col"> <a href="dien-dan" style="color: white">Quay lại diễn đàn</a> </div>
            </div>
        </div>
        <div class="container pt-5 pb-5">
            <div class="row">
                <div class="col-lg-6 offset-lg-3">
                    <h4>ĐĂNG NHẬP</h4>
                    <form id="form" method="POST">
                        <div class="form-group">
                            <label> Tài khoản:</label>
                            <input class="form-control" type="text" name="username" id="username"
                                placeholder="Nhập tài khoản">
                        </div>
                        <div class="form-group">
                            <label> Mật khẩu:</label>
                            <input class="form-control" type="password" name="password" id="password"
                                placeholder="Nhập mật khẩu">
                        </div>
                        <div class="form-check form-group">
                            <label class="form-check-label">
                                <input class="form-check-input" type="checkbox" name="accept" id="accept" checked="">
                                Ghi nhớ đăng nhập
                            </label>
                        </div>
                        <?php
                        if (!empty($_alert)) {
                            echo $_alert;
                        }
                        ?>
                        <div id="notify" class="text-danger pb-2 font-weight-bold"></div>
                        <button class="btn btn-main form-control" type="sumbit">ĐĂNG
                            NHẬP</button>
                    </form>
                </div>
            </div>
            <div class="text-center">
                <p>Bạn chưa có tài khoản <a href="/dang-ky">Đăng ký tại đây</a></p>
            </div>
        </div>
        <div class="border-secondary border-top"></div>
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
    </div>
    <script src="assets/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="asset/main.js"></script>
</body>

</html>
