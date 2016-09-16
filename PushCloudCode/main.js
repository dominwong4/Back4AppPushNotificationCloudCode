Parse.Cloud.define("pushsample", function(request, response) {
        Parse.Push.send({
        		channels:['test_channel'],
                data: {
                        title: "HI Test From Cloud Code",
                        message: "From Cloud Code",
                }
        }, {
                success: function() {
                        // Push was successful
                        response.success("sendAnnouncement sent");
                },
                error: function(error) {
                        // Handle error
                        console.log("PUSH ERORR");
                        response.error("error with sendAnnouncement: " + error);
                },
                useMasterKey: true
        });
});