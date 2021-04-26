var http = require('http')
var Cookies = require('cookies')
var Router = require('router')
var url = require('url')
var path = require('path')
var finalhandler = require('finalhandler')
var router = Router()
var mysql = require('mysql')
var fs = require('fs')
var bodyParser = require("body-parser");
var qs = require('querystring')



var keys = ['keyboard cat']
var connection = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: '123',
    database: 'Zow_Atlas'
});

router.get('/login.html', function(req, res) {
    const pathname = url.parse(req.url).pathname;
    var cookies = new Cookies(req, res, { keys: keys })

    var lastVisit = cookies.get('LastVisit', { signed: true })
    var username = cookies.get('username', { signed: true })
    var relogin = cookies.get('relogin', { signed: true });

    cookies.set('LastVisit', new Date().toISOString(), { signed: true })
    console.log(lastVisit + "----" + username + "--" + relogin);
    if (!lastVisit && !username) {
        fs.readFile(__dirname + pathname + '', (err, data) => {
            if (err) {
                res.writeHead(404, { 'Content-type': 'application/json' });
                res.write('Page not found' + JSON.stringify(err));
                res.end();
            } else {
                res.writeHead(200, { 'Content-type': 'text/html' });
                res.write(data);
                res.end();
            }
        })
    } else {
        if (!relogin) {
            cookies.set('username', { expires: Date.now() });
            cookies.set('LastVisit', { expires: Date.now() });
            res.writeHead(301, { Location: 'login.html' });
            res.end();
        } else {
            res.setHeader('Content-Type', 'text/plain')
            res.end('Welcome back! Nothing much changed since your last visit at ' + lastVisit + '.')
        }
    }
});

router.post('/auth', function(req, res) {
    var body = '';
    req.on('data', function(data) {
        body += data;
        if (body.length > 1e6)
            req.connection.destroy();
    });
    req.on('end', function() {
        var post = qs.parse(body);
        var username = post.username;
        var password = post.password;
        var cookies = new Cookies(req, res, { keys: keys });
        if (username && password) {
            connection.query('SELECT * FROM user WHERE user_name = ? AND password_hash = ? ;', [username, password], function(error, results, fields) {
                if (results.length > 0) {
                    cookies.set('username', username, { signed: true });
                    cookies.set('last-active', new Date().toISOString(), { signed: true });
                    res.writeHead(301, { Location: 'index.html' })
                        //req.session.loggedin = true;
                        //req.session.username = username;
                        //res.redirect('/home');
                } else {
                    res.writeHead(200, { 'Content-type': 'text/plain' });
                    res.write("Invalid password or username check again");
                    //res.end();
                }
                res.end();
            });
        } else {
            res.send('Please enter Username and Password!');
            res.end();
        }
    });
});


router.get('/index.html', function(req, res) {
    var cookies = new Cookies(req, res, { keys: keys });
    var lastVisit = cookies.get('LastVisit', { signed: true })
    var username = cookies.get('username', { signed: true })


    if (username && lastVisit) {
        fs.readFile(__dirname + url.parse(req.url).pathname + '', (err, data) => {
            if (err) {
                res.writeHead(404, { 'Content-type': 'application/json' });
                res.write('Page not found' + JSON.stringify(err));
                res.end();
            } else {
                res.writeHead(200, { 'Content-type': 'text/html' });
                res.write(data);
                res.end();
            }
        });
    } else {
        res.writeHead(200, { 'Content-type': 'text/plain' });
        res.write("YOU MUST BE LOGGED ! ");
        res.end();
    }
});

router.get('/logout.html', function(req, res) {
    var cookies = new Cookies(req, res, { keys: keys })
    res.writeHead(301, { Location: 'login.html' });
    res.end();
});

var server = http.createServer(function(req, res) {
    console.log('req URL : ' + req.url);
    const pathname = url.parse(req.url).pathname;
    console.log('PathName : ' + pathname);
    router(req, res, finalhandler(req, res))
})

server.listen(3000, function() {
    console.log('Visit us at http://127.0.0.1:3000/ !')
})